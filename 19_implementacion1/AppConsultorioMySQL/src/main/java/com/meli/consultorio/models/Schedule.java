package com.meli.consultorio.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalTime;

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
    private LocalTime scheduleFrom;

    @Column(name = "schedule_to")
    private LocalTime scheduleTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

}
