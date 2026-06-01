package com.qsp.appointment_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.appointment_booking.entity.Doctor;

public interface DoctorRepository
        extends JpaRepository<Doctor, Long> {

}