package com.barbershop.barbershop.DTOS.appointments;

import com.barbershop.barbershop.entities.Appointment;
import com.barbershop.barbershop.enumns.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


public class AppointmentInputDTO implements Serializable {
    private Integer customerId;
    private Integer barbershopId;
    private LocalDateTime appointmentTime;
    private AppointmentStatus appointmentStatus;
public AppointmentInputDTO(
        Integer customerId , Integer barbershopId , LocalDateTime appointmentTime , AppointmentStatus appointmentStatus
) {
    this.customerId = customerId;
    this.barbershopId = barbershopId;
    this.appointmentTime = appointmentTime;
    this.appointmentStatus = appointmentStatus;
}
public AppointmentInputDTO() {}
    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public Integer getBarbershopId() {
        return barbershopId;
    }

    public Integer getCustomerId() {
        return customerId;
    }
    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setBarbershopId(Integer barbershopId) {
        this.barbershopId = barbershopId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
