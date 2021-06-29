package com.meli.muelitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Entity
public class Turn {
    @Id
    @Column(name = "id_turn")
    private long id;

    private Time startTime;

    @ManyToOne
    private Schedule schedule;

    @ManyToOne()
    private Patient patient ;
}
