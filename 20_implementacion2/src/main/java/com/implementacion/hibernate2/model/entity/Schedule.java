package com.implementacion.hibernate2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;



    @OneToOne(mappedBy = "schedule")
    private Dentist dentist;

    @OneToMany(mappedBy = "schedule")
    private Set<Appointment> appointments;

}
