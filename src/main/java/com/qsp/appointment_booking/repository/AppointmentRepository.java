package com.qsp.appointment_booking.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.appointment_booking.entity.Appointment;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    Appointment findByDoctorIdAndStartTime(
            long doctorId,
            LocalDateTime startTime);
}