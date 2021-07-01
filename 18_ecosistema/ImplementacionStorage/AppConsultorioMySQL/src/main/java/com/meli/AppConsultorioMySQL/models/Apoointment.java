package com.meli.AppConsultorioMySQL.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "apoointments")
@NoArgsConstructor
public class Apoointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private int durations;
    // status 1 -> Pending, 2-> Finish 3-> Reprogrammed 4->Cancel
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private Patient patient;


}
