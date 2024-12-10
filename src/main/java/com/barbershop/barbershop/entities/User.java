package com.barbershop.barbershop.entities;

import com.barbershop.barbershop.enumns.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
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



}
