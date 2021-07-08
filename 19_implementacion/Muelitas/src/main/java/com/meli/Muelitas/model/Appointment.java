package com.meli.Muelitas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;
    // status 1 -> Pending, 2-> Finish 3-> Postponed 4->Cancel
    private int status;

    @ManyToOne
    private Professional professional;
    @ManyToOne
    private Patient patient;
}
