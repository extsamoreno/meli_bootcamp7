package com.meli.claseSpring2.web.response;

import com.meli.claseSpring2.web.dto.HabitacionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AreasResponse {
    private String habitacion;
    private double area;

}
