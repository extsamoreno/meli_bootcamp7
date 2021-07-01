package com.example.muelitas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "appointments")
@AllArgsConstructor @NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "appointment_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "appointment_cancellationDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cancellationDate;

    @Column(name = "status")
    String status;

    @ManyToOne
    @JoinColumn(name = "appointment_professional", referencedColumnName = "professional_id")
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "appointment_patient", referencedColumnName = "patient_id")
    private Patient patient;

}
