package com.desafrio2.Desafio1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Named;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {
    private String name;
    private double width;
    private double length;

    public double area(){
        return this.width * this.length;
    }
}
