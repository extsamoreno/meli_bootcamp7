package com.meli.consultorio.models;

import lombok.*;
import javax.persistence.*;
import java.sql.Time;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "schedule_day")
    private Integer scheduleDay;

    @Column(name = "schedule_from")
    private Time scheduleFrom;

    @Column(name = "schedule_to")
    private Time scheduleTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

}
