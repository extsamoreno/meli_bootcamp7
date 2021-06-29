package com.meli.persistence.repositories.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String dni;
    @Column
    private String name;
    @Column
    private String lastName;

    public StudentEntity(String dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastname;
    }

}