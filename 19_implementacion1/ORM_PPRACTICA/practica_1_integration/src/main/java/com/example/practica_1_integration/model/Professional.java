package com.example.practica_1_integration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Professionals")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String enrollment;
    private String profesion;
   // @OneToMany(mappedBy = "professional", fetch = FetchType.EAGER)
   // private Set<Turn> turn;

    @Override
    public String toString() {
        return "Professional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", enrollment='" + enrollment + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
