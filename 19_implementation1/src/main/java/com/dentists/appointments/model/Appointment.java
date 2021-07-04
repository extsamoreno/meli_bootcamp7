package com.dentists.appointments.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Appointmets")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_den", referencedColumnName = "den_id")
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_pat", referencedColumnName  = "pat_id")
    private Patient patient;

    @Column(name = "app_date")
    private LocalDate date;

    @Column(name = "app_time")
    private LocalTime time;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "app_status")
    private Status status;

    @OneToOne()
    @JoinColumn(name = "new_rep", referencedColumnName = "app_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Appointment reProgram;
}
