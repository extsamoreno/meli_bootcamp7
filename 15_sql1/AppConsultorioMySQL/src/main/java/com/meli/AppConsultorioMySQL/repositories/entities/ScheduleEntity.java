package com.meli.AppConsultorioMySQL.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedules")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date init;
    private Date finish;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private DentistEntity dentist;

}
