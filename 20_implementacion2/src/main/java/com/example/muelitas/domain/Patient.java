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
@Document(collection= "patients")
public class Patient {
    @Id
    private String id;

    @Field(name="firstName")
    private String firstName;

    @Field(name="lastName")
    private String lastName;

    @Field(name="age")
    private int age;

    @Field(name="gender")
    private String gender;
}
