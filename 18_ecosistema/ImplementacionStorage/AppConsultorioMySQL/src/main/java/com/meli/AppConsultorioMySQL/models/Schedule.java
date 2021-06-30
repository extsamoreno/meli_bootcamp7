package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date_init;
    private Date date_finish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Dentist dentist;

    @OneToMany(mappedBy = "schedule")
    private Set<Apoointment> apoointment;

    public Schedule(Long id, Date date_init, Date date_finish, Dentist dentist, Set<Apoointment> apoointment) {
        this.id = id;
        this.date_init = date_init;
        this.date_finish = date_finish;
        this.dentist = dentist;
        this.apoointment = apoointment;
    }
}
