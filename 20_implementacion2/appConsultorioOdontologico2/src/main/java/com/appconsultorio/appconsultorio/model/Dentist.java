package com.appconsultorio.appconsultorio.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.*;

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

    @ManyToMany(mappedBy = "dentistset", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Turn> turnSet;

    //orphanRemoval= true especifica que la entidad hijo debe ser eliminada automáticamente por el propio ORM si ha
    // dejado de ser referenciada por una entidad padre
    @OneToOne(mappedBy = "dentist", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)

    private Calendars calendars;

}
