package meli.meli_app_consultorio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private Long id;
    @Column(name = "pat_name")
    private String name;
    @Column(name = "pat_dni")
    private String dni;
    @Column(name = "pat_address")
    private String address;
    @Column(name = "pat_social_work")
    private String socialWork;

//    @OneToMany(mappedBy = "patients_pat_id")
//    private Set<Appointment> appointments;
}
