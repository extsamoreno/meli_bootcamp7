package com.bootcamp.appconsultoriomysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "professionals")
@Getter
@Setter
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_dni")
    private String dni;

    @Column(name = "pro_name")
    private String name;

    @Column(name = "pro_lastname")
    private String lastname;

    @OneToMany(mappedBy = "professional", fetch = FetchType.LAZY)
    private Set<Turn> turns;

}
