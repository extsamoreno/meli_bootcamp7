package com.example.muelitas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "profesionales")
@AllArgsConstructor
@NoArgsConstructor
public class Profesional {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String legajo;
    private String matricula;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "esp_id")
    private Especialidad especialidad;
}

/*
*  - - EAGER - -
* profesional
*
* id = 123
* nombre = juan
* especialidad = {
*   id = 123,
*   name = doctor de perros
* }
*
*
*  - - LAZY - -
* profesional
*
* id = 123
* nombre = juan
* especialidad = lo ignora (?)
*
* */
