package com.meli.consultory.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "professionals")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long dni;
    private String name;
    private String surname;
    private int hourInit;
    private int minuteInit;
    private int hourFinish;
    private int minuteFinish;

    @OneToMany(mappedBy = "professional")
    private Set<Turn> professional;

}
