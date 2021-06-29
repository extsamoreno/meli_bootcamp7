package com.example.demo.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Schedule {

    private long id;
    private Date date;
    private long idDentist;
}
