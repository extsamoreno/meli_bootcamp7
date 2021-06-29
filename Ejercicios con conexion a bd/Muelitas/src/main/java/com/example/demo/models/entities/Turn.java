package com.example.demo.models.entities;

import javax.persistence.Entity;
import java.sql.Time;

@Entity
public class Turn {

    private long idPatient;
    private long schedule;
    private Time startTime;

}
