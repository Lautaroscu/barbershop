package com.barbershop.barbershop.entities;

import com.barbershop.barbershop.enumns.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_barbershop")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long dni;
    private UserType userType;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    @OneToOne
    @JoinColumn(name = "wallet_id" ,referencedColumnName = "id")
    private Wallet wallet;
    private boolean blocked;

    public int getId() {
        return id;
    }

    public long getDni() {
        return dni;
    }
    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
