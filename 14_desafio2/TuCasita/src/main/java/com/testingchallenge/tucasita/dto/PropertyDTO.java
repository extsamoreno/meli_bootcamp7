package com.testingchallenge.tucasita.dto;

import com.testingchallenge.tucasita.model.Neighborhood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// US001 - get a property's area

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private String name;
    private Double area;
}
