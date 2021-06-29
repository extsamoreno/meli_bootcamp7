package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "pacients")
@NoArgsConstructor
public class PacientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name= "last_name")
    private String lastName;
    private String dni;

    @OneToMany (mappedBy = "pacientEntity")
    private Set<AppointmentEntity> appointmentEntitySet;

}
