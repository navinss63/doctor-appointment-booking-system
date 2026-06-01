package com.qsp.appointment_booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qsp.appointment_booking.entity.Appointment;
import com.qsp.appointment_booking.service.AppointmentService;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment")
    public Appointment addAppointment(
            @RequestBody Appointment appointment) {

        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointments() {

        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/appointment/{id}")
    public String cancelAppointment(
            @PathVariable long id) {

        return appointmentService.cancelAppointment(id);
    }
}