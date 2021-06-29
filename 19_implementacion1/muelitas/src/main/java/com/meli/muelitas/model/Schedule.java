package com.meli.muelitas.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @Column(name = "id_schedule")
    private long id;
    private Date date;
    private long idDentist;

    @ManyToOne
    private Dentist dentist;

    @OneToMany(mappedBy = "schedule")
    private Set<Turn> turns;
}
