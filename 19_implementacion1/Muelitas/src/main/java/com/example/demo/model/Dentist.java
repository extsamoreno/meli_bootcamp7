package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "den_id")
    private Integer id;

    @Column(name = "den_name")
    private String name;

    @Column(name = "den_phoneNumber")
    private String phoneNumber;

    @Column(name = "des_startTime")
    private Date startTime;

    @Column(name = "des_endTime")
    private Date endTime;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "consultory_id",referencedColumnName = "con_id")
    private Consultory consultory;


    @ManyToMany
    @JoinTable(
            name = "Dentist_and_Boss",
            joinColumns =@JoinColumn(name = "Dentist", referencedColumnName= "den_id"),
            inverseJoinColumns = @JoinColumn(name = "Boss", referencedColumnName = "bos_id")

    )
    private Set<Boss> bosses;



   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String startTime;
    private String endTime;*/
}
