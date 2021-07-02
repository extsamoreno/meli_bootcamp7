package com.meli.AppConsultorioMySQL.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "dentists")
@NoArgsConstructor
@AllArgsConstructor
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    public DentistEntity(String dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }
}
