package com.bootcamp.appconsultoriomysql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turns")
@Getter
@Setter
@ToString
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_id")
    private Long id;

    @Column(name = "tur_date_start")
    private LocalDateTime dateStart;

    @Column(name = "tur_date_end")
    private LocalDateTime dateEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "tur_status")
    private TurnStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pro_id", foreignKey = @ForeignKey(name = "pro_id"))
    private Professional professional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pat_id", foreignKey = @ForeignKey(name = "pat_id"))
    private Patient patient;
}
