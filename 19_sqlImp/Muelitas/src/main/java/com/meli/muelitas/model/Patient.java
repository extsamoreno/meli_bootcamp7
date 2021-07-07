package com.meli.muelitas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String nit;

    private Integer age;

    private Integer phoneNumber;


}
