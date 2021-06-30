package com.example.mongodbexample.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "schedules")
public class Schedule {
    @Id
    private String id;
    private Patient patient;
    private Doctor doctor;
//    private LocalDate date;
    private String status;
}
