package com.example.practica_1_integration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Turns")
public class Turn {
    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", date=" + date +
                ", state='" + state + '\'' +
                ", newTurn=" + newTurn +
                ", professional=" + professional +
                ", patient=" + patient +
                ", service=" + service +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    private String state;

    @OneToOne
    @JoinColumn(name = "new_turn_id", referencedColumnName = "id")
    private Turn newTurn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="professional_id", referencedColumnName = "id")
    private Professional professional;

    @ManyToOne
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="service_id", referencedColumnName = "id")
    private Service service;
}
