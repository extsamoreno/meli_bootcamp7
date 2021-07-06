package com.consultoriomongo.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Doctor {

    private String name;
    @Field("edad")
    private int age;
}
