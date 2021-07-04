package com.dentists.appointments.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "den_id")
    private long id;

    @Column(name = "den_name")
    private String name;

    @Column(name = "den_tel")
    private String tel;

    @Column(name = "den_dni")
    private String dni;

}
