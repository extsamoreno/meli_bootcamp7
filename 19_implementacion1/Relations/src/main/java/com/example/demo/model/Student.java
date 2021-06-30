package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String dni;

    @OneToOne
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;
}
