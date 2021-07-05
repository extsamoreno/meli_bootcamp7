package com.muelitas.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "status")
    private Turn turn;

}
