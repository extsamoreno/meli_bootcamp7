package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String lastname;

    @ManyToOne()
    @JoinColumn(name="schedule_id", referencedColumnName = "id")
    private ScheduleEntity scheduleEntity;

    public DentistEntity(Long id, String dni, String name, String lastname, ScheduleEntity scheduleEntity) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.scheduleEntity = scheduleEntity;
    }
}
