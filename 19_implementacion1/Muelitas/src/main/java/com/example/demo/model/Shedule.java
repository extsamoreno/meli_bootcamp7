package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "shedules")
public class Shedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "she_id")
    private Integer id;

    @Column(name = "she_name")
    private String name;



}
