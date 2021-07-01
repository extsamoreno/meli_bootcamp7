package com.example.demo.model;

import com.example.demo.model.enums.StateAppoiment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "appointment_date")
    private Date date;

    @OneToOne
    private Patient patient;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    @JsonIgnore
    private Dentist dentist;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateAppoiment state;
}
