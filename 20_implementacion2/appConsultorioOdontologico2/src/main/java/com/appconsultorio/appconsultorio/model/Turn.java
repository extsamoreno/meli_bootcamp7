package com.appconsultorio.appconsultorio.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "Turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "status")
    private String status;

    @Column(name = "id_to_reprog_turn")
    private Integer idToReprogTurn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "schedule",
            joinColumns = @JoinColumn(name = "id_turn"),
            inverseJoinColumns = @JoinColumn(name = "id_dentist")
            
    )
    private Set<Dentist> dentistset;

    /*
    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private Dentist profesional;
*/
}
