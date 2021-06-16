package com.TuCasitaTasacionesAPI.TuCasita.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorValidationsDTO {
    private String message;
    private String type;
    private Map<String, String> fields;
}
