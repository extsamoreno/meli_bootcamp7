package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "bosses")
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bos_id")
    private Integer id;

    @Column(name = "bos_nombre")
    private String nombre;

    @ManyToMany(mappedBy = "bosses")
    private Set<Dentist> dentists;


}
