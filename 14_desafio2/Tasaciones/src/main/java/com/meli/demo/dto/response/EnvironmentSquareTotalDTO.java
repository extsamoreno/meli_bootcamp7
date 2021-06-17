package com.meli.demo.dto.response;

import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnvironmentSquareTotalDTO {

    private EnvironmentDTO environments;
    private double totalSquare;

}
