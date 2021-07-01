package com.appconsultorio.appconsultorio.model;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "adress")
    private String address;

    @Column(name = "phone")
    private Integer phone;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Turn> turnSet;
}
