package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "dentists")
@NoArgsConstructor
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    @Column(name = "last_name")
    private String lastname;


    @OneToMany(mappedBy = "dentist")
    private Set<SchedulesEntity> schedulesEntitySet;
}
