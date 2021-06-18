package com.tucasitaTasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    private String environment_name;
    private Integer environment_width;
    private Integer environment_length;
    private Integer squareFeet;

    public Environment(String environment_name, Integer environment_width, Integer environment_length) {
        this.environment_name = environment_name;
        this.environment_width = environment_width;
        this.environment_length = environment_length;
    }

    public Integer getSquareFeet() {
        Integer result = 0;
        if (environment_width != null && environment_length != null)
            result = this.environment_width * this.environment_length;
        return result;
    }
}
