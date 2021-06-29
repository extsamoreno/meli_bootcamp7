package meli.meli_app_consultorio.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long id;
    @Column(name = "app_date")
    private Date date;
    @Column(name = "patients_pat_id")
    private Long patId;
    @Column(name = "dentists_den_id")
    private Long denId;

//    @ManyToOne
//    private Patient patient;
//
//    @ManyToOne
//    private Dentist dentist;




}
