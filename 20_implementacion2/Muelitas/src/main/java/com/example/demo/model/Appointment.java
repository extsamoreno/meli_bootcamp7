package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Integer id;

    @Column(name = "app_date")
    private String date;

    @Column(name = "app_status")
    private String status;

    @Column(name = "app_reschedule")
    private String reschedule;

    @ManyToOne
    @JoinColumn(name ="patient_id",nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name ="dentist_id",nullable = false)
    private Dentist dentist;


}
