package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "den_name")
    private String name;

    @Column(name = "den_enrollment")
    private Long enrollment;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Schedule> schedules;
}