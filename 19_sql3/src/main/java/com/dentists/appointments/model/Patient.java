package com.dentists.appointments.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private long id;

    @Column(name = "pat_name")
    private String name;

    @Column(name = "pat_tel")
    private String tel;

    @Column(name = "pat_dni")
    private String dni;

}
