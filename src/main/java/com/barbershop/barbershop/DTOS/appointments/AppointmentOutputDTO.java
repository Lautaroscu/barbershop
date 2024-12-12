package com.barbershop.barbershop.DTOS.appointments;


import com.barbershop.barbershop.DTOS.serviceType.ServiceTypeOutputDTO;
import com.barbershop.barbershop.entities.Appointment;
import com.barbershop.barbershop.entities.ServiceType;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AppointmentOutputDTO  extends AppointmentInputDTO  {
        private int appointmentId;
        private Set<ServiceTypeOutputDTO> serviceTypes;
        public AppointmentOutputDTO(Appointment appointment) {
            super(appointment.getCustomer().getId() , appointment.getBarbershop().getId() ,appointment.getDate() ,appointment.getAppointmentStatus());
            this.appointmentId = appointment.getId();
            this.serviceTypes = appointment
                    .getAvailableServices()
                    .stream()
                    .map(ServiceTypeOutputDTO::new)
                    .collect(Collectors.toSet());

        }

}
