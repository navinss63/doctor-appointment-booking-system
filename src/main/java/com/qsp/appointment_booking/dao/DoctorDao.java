package com.qsp.appointment_booking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.appointment_booking.entity.Doctor;
import com.qsp.appointment_booking.repository.DoctorRepository;

@Repository
public class DoctorDao {

    @Autowired
    private DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }
}