package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private Set<Student> students;

    @ManyToMany
    @JoinTable(
            name = "classroom_and_course",
            joinColumns =@JoinColumn(name = "pepito", referencedColumnName= "id"),
            inverseJoinColumns = @JoinColumn(name = "pepito2", referencedColumnName = "id")

    )
    private Set<Classroom> classrooms;
}
