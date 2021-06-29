package meli.meli_app_consultorio.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "den_id")
    private Long id;
    @Column(name = "den_name")
    private String name;
    @Column(name = "den_phone_number")
    private String phoneNumber;
    @Column(name = "den_start_time")
    private Time startTime;
    @Column(name = "den_end_time")
    private Time endTime;

//    @OneToMany(mappedBy = "dentists_den_id")
//    private Set<Appointment> appointments;

}
