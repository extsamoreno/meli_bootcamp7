package com.example.muelitas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "professionals")
@AllArgsConstructor @NoArgsConstructor
public class Professional {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "professional_id")
    private Long id;

    @Column(name = "professional_name")
    private String name;

    @Column(name = "professional_record")
    private String record;

    @Column(name = "professional_license")
    private String license;

}
