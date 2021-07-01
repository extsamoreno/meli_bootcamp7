package com.example.practica_1_integration.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "professional")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "enrollment")
    private String enrollment;

/*    @OneToMany(mappedBy = "professional", fetch = FetchType.LAZY) // este atributo no lo puso gian
    private Set<Appointment> appointment;*/
}
