package com.meli.AppConsultorioMySQL.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Entity
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date_init;
    private Date date_finish;

    @OneToMany(mappedBy = "dentist")
    private Set<DentistEntity> dentistEntitySet;

    @ManyToOne()
    @JoinColumn(name="appointments_id", referencedColumnName = "id")
    private ApoointmentEntity apoointmentEntity;

    public ScheduleEntity(Long id, Date date_init, Date date_finish, String lastname, Set<DentistEntity> dentistEntitySet, ApoointmentEntity apoointmentEntity) {
        this.id = id;
        this.date_init = date_init;
        this.date_finish = date_finish;
        this.dentistEntitySet = dentistEntitySet;
        this.apoointmentEntity = apoointmentEntity;
    }
}
