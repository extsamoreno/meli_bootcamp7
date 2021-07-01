package com.example.mongodbexample.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "schedules")
public class Schedule {
    @Id private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String status;
}
