package com.meli.muelitas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter @Setter
public class Dentist {
    @Id
    @Column(name = "id_dentista")
    private long idDentist;
    private String name;
    private long enrollment;

    @OneToMany(mappedBy = "dentist")
    private Set<Schedule> schedule;
}
