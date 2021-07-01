package com.appconsultorio.appconsultorio.model;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany(mappedBy = "dentistset")
    Set<Turn> turnSet;
}
