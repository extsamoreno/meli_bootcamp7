package com.spring3.clase3spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesDTO {

    private String name;
    private int calories;

}
