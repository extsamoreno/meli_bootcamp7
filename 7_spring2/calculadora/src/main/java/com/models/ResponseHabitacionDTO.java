package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHabitacionDTO {

    private Casa casa;
    private ArrayList<Double> resultado;
}
