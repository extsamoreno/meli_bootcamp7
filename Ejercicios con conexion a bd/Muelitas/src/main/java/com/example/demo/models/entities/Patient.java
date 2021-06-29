package com.example.demo.models.entities;

import javax.persistence.Entity;

@Entity
public class Patient {

    private long idPatient;
    private String name;
    private long dni;
    private long phone;

}
