package com.qsp.appointment_booking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.appointment_booking.entity.Appointment;
import com.qsp.appointment_booking.exception.SlotAlreadyBookedException;
import com.qsp.appointment_booking.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment bookAppointment(Appointment appointment) {

        if (appointment.getStartTime()
                .isBefore(LocalDateTime.now())) {

            throw new RuntimeException("Invalid time");
        }

        Appointment existing =
                repository.findByDoctorIdAndStartTime(
                        appointment.getDoctorId(),
                        appointment.getStartTime());

        if (existing != null) {

            throw new SlotAlreadyBookedException(
                    "Slot already booked");
        }

        appointment.setStatus("BOOKED");

        return repository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public String cancelAppointment(long id) {

        repository.deleteById(id);

        return "Appointment Cancelled";
    }
}