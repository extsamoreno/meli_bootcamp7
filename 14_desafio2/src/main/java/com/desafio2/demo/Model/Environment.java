package com.desafio2.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

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
