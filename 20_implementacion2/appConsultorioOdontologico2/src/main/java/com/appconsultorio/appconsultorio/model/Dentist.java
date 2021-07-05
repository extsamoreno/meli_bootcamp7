package com.appconsultorio.appconsultorio.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @Column(name = "")

    @ManyToMany(mappedBy = "dentistset", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Turn> turnSet;
}
