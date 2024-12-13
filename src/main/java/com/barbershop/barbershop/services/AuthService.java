package com.barbershop.barbershop.services;


import com.barbershop.barbershop.DTOS.user.LoginInputDTO;
import com.barbershop.barbershop.DTOS.user.UserInputDTO;
import com.barbershop.barbershop.entities.User;
import com.barbershop.barbershop.exceptions.InvalidCredentialsException;
import com.barbershop.barbershop.repositories.UserRepository;
import com.barbershop.barbershop.security.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil; // Asegúrate de tener tu JwtUtil configurado
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    public void register(UserInputDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        if (!equalsPasswords(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPhone(userDTO.getPhone());
        user.setUserType(userDTO.getUserType());
        userRepository.save(user);

    }

    public String authenticate(LoginInputDTO request) {
        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(userDetails);

        } catch (AuthenticationException e) {
            // Manejar errores de autenticación
            throw new InvalidCredentialsException("Invalid credentials");
        }
    }


    private boolean equalsPasswords(String password1, String password2) {
        return password2.equals(password1);
    }


    public boolean tokenValid(String token) {
        try {
            return jwtUtil.validateToken(token);
        } catch (JwtException e) {
            throw new JwtException("Invalid token");
        }
    }

}
