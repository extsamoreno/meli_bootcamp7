package com.implementacion.hibernate2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id", foreignKey = @ForeignKey(name = "id") /*referencedColumnName = "id"*/ )
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "id") /*referencedColumnName = "id"*/ )
    private Patient patient;

}
