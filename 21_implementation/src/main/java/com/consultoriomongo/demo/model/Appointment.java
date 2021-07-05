package com.consultoriomongo.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalTime;

@Document
public class Appointment {

    LocalDate date;
    LocalTime time;
    Doctor doctor;
    @Field(name = "paciente")
    Patient patient;

}
