package com.randomstudent.demo.Model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "MAIL")
    String mail;

    @Column(name = "TEL")
    String tel;

}
