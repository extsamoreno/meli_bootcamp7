package muelitas1.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    @ManyToOne
    Dentist dentist;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    Set<Appointment> appointments;
}
