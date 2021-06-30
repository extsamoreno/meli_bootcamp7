package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tur_time")
    private Time time;

    @ManyToOne(fetch = FetchType.LAZY)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}