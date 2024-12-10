package com.barbershop.barbershop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "admin_id" , referencedColumnName = "id")
    private User admin;
    @OneToOne
    @JoinColumn(name = "address_id" , referencedColumnName = "id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "barbershop_service", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "barbershop_id"), // Nombre de la columna de clave foránea hacia Barbershop
            inverseJoinColumns = @JoinColumn(name = "service_type_id") // Nombre de la columna de clave foránea hacia ServiceType
    )
    private Set<ServiceType> serviceTypeList;

    private boolean verified;


}
