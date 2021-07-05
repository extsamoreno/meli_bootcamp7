package com.muelitas.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    private LocalDateTime start_date;

    private LocalDateTime end_date;
    
    @OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToOne
    @JoinColumn(name = "reprogrammed_id", referencedColumnName = "id")
    private Turn turn;
}
