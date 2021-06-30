package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="consultories")
public class Consultory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="con_id")
    private Integer id;

    @Column(name="con_adress")
    private String adress;

    @Column(name="con_phone")
    private String phoneNumber;

    @OneToOne(mappedBy = "consultory")
    private Dentist dentist;



}
