package com.bootcamp.tucasitatasaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyAppraisalDTO {

    private String propertyName;
    private Double propertyValue;
}
