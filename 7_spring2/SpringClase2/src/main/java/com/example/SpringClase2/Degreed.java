package com.example.SpringClase2;

import lombok.Data;

@Data

public class Degreed {
    private String name;
    private double average;
    private String mensaje;

    public Degreed(String name, double average){
        this.name = name;
        this.average = average;
        this.mensaje = this.name +  " have pass this asignature with " + this.average;
        menssage();
    }

    public void menssage(){
        if(this.average >= 9){
            this.mensaje = "¡Congratulations!\n" + this.mensaje;
        }
    }
}
