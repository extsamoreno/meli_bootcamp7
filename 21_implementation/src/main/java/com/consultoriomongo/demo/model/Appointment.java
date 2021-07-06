package com.consultoriomongo.demo.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(value = "Appoiment")
public class Appointment {

    String date;
    String time;

    Doctor doctor;

    @Field(name = "paciente")
    Patient patient;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String status;

}
