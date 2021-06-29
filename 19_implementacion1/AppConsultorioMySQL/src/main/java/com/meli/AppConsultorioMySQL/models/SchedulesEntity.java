package com.meli.AppConsultorioMySQL.models;

import lombok.Data;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "schedules")
public class SchedulesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "date_init")
    private Date dateInit;
    @Column(name = "date_finish")
    private Date dateFinish;

    @ManyToOne
    @JoinColumn
    private DentistEntity dentist;

}
