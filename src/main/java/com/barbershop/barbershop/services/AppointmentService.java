package com.barbershop.barbershop.services;

import com.barbershop.barbershop.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
private final AppointmentRepository appointmentRepository;

@Autowired
public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
}

}
