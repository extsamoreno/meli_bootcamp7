package com.appconsultorio.appconsultorio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Calendars")
public class Calendars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendar")
    private int id;

    @Column(name = "day")
    private Date day;

    //jornada de 8hs, 16 turnos de media hora
    @Column(name = "turn1")
    private boolean turn1;
    @Column(name = "turn2")
    private boolean turn2;
    @Column(name = "turn3")
    private boolean turn3;
    @Column(name = "turn4")
    private boolean turn4;
    @Column(name = "turn5")
    private boolean turn5;
    @Column(name = "turn6")
    private boolean turn6;
    @Column(name = "turn7")
    private boolean turn7;
    @Column(name = "turn8")
    private boolean turn8;
    @Column(name = "turn9")
    private boolean turn9;
    @Column(name = "turn10")
    private boolean turn10;
    @Column(name = "turn11")
    private boolean turn11;
    @Column(name = "turn12")
    private boolean turn12;
    @Column(name = "turn13")
    private boolean turn13;
    @Column(name = "turn14")
    private boolean turn14;
    @Column(name = "turn15")
    private boolean turn15;
    @Column(name = "turn16")
    private boolean turn16;

    //La columna id_dentist en la tabla Calendars tiene la FK
    @JoinColumn(name = "id_dentist")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Dentist dentist;

    public Calendars(Dentist dentist) {
        this.dentist = dentist;
    }

    public boolean createTurn(LocalDateTime date){
       if(date.getHour() == 8 && date.getMinute() == 00) {this.setTurn1(true); return true;}
       if(date.getHour() == 8 && date.getMinute() == 30) {this.setTurn2(true); return true;}
       if(date.getHour() == 9 && date.getMinute() == 00) {this.setTurn3(true); return true;}
       if(date.getHour() == 9 && date.getMinute() == 30) {this.setTurn4(true); return true;}
       if(date.getHour() == 10 && date.getMinute() == 00) {this.setTurn5(true); return true;}
       if(date.getHour() == 10 && date.getMinute() == 30) {this.setTurn6(true); return true;}
       if(date.getHour() == 11 && date.getMinute() == 00) {this.setTurn7(true); return true;}
       if(date.getHour() == 11 && date.getMinute() == 30) {this.setTurn8(true); return true;}
       if(date.getHour() == 12 && date.getMinute() == 00) {this.setTurn9(true); return true;}
       if(date.getHour() == 12 && date.getMinute() == 30) {this.setTurn10(true); return true;}
       if(date.getHour() == 13 && date.getMinute() == 00) {this.setTurn11(true); return true;}
       if(date.getHour() == 13 && date.getMinute() == 30) {this.setTurn12(true); return true;}
       if(date.getHour() == 14 && date.getMinute() == 00) {this.setTurn13(true); return true;}
       if(date.getHour() == 14 && date.getMinute() == 30) {this.setTurn14(true); return true;}
       if(date.getHour() == 15 && date.getMinute() == 00) {this.setTurn15(true); return true;}
       if(date.getHour() == 15 && date.getMinute() == 30) {this.setTurn16(true); return true;}
       return false;
    }
}
