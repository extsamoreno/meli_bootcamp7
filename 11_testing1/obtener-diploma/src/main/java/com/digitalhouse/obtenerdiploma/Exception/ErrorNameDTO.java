package com.digitalhouse.obtenerdiploma.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorNameDTO {
    String type;
    String name;
}
