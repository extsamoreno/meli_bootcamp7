package com.example.mongoimpl.dto;

import com.example.mongoimpl.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ScheduleDoctorDTO {

    @Id
    private String id;
    private Patient patient;
    private LocalDate date;
    private String status;
}