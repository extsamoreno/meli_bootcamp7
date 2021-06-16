package com.TuCasitaTasacionesAPI.TuCasita.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    private String environment_name;
    private Double environment_width;
    private Double environment_length;
}
