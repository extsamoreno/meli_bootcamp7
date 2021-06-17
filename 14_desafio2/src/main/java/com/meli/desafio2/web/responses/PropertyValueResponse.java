package com.meli.desafio2.web.responses;

import com.meli.desafio2.web.model.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValueResponse {
    private Property property;
    private double value;
}
