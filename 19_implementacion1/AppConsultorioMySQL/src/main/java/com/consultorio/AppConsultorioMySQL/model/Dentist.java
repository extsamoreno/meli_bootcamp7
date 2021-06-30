package com.consultorio.AppConsultorioMySQL.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;

}