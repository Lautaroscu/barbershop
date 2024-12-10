package com.barbershop.barbershop.entities;

import com.barbershop.barbershop.enumns.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String description;
    private AppointmentStatus appointmentStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;
    @ManyToMany
    @JoinTable(name = "available_services" , joinColumns = @JoinColumn(name = "appointment_id") ,
    inverseJoinColumns = @JoinColumn(name = "service_type_id"))
    private Set<ServiceType> availableServices;


}
