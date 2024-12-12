package com.barbershop.barbershop.entities;

import com.barbershop.barbershop.enumns.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private String description;
    private AppointmentStatus appointmentStatus;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;
    @ManyToMany
    @JoinTable(name = "available_services" , joinColumns = @JoinColumn(name = "appointment_id") ,
    inverseJoinColumns = @JoinColumn(name = "service_type_id"))
    private Set<ServiceType> availableServices;

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public Barbershop getBarbershop() {
        return barbershop;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Set<ServiceType> getAvailableServices() {
        return availableServices;
    }

    public String getDescription() {
        return description;
    }

    public User getCustomer() {
        return customer;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void setAvailableServices(Set<ServiceType> availableServices) {
        this.availableServices = availableServices;
    }

    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
