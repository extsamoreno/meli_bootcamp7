package com.consultorio.AppConsultorioMySQL.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dentist_id", referencedColumnName = "id")
    private Dentist dentist;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="turn_id", referencedColumnName = "id")
    private Turn turn;
}
