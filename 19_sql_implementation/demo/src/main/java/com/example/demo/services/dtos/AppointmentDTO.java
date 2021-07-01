package com.example.demo.services.dtos;

import com.example.demo.model.Dentist;
import com.example.demo.model.Patient;
import com.example.demo.model.enums.StateAppoiment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO implements Serializable{

    private Long id;

    private Date appointment_date;

    private Patient patient;

    private String dentistName;

    private Long dentistid;

    private String state;
}
