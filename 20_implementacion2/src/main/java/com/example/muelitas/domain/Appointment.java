package com.example.muelitas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Document(collection= "appointments")
public class Appointment {
    @Id
    private String id;

    @DBRef
    private Patient patient;

    @DBRef
    private Doctor doctor;

    @Field(name="date")
    private String date;

    @Field(name="status")
    private String status;
}
