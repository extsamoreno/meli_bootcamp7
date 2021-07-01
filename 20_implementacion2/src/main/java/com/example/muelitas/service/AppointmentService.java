package com.example.muelitas.service;

import com.example.muelitas.dto.AppointmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    List<AppointmentDTO> findAll();
    List<AppointmentDTO> findAllByDoctor(String idDoctor);
    List<AppointmentDTO> findAllCancelled();
    List<AppointmentDTO> findAllActive();
}
