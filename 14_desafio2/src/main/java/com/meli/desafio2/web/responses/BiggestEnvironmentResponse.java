package com.meli.desafio2.web.responses;

import com.meli.desafio2.web.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiggestEnvironmentResponse {
    private String prop_name;
    private Environment biggest_environment;
}
