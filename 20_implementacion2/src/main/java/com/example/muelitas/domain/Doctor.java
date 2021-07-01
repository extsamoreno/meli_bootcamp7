package com.example.muelitas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "doctors")
public class Doctor {
    @Id
    private String id;

    @Field(name="firstName")
    private String firstName;

    @Field(name="lastName")
    private String lastName;

    @Field(name="speciality")
    private String speciality;
}
