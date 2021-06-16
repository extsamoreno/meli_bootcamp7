package com.desafrio2.Desafio1.Model.DTO;

import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropRequest {
    private String name;
    private District district;
    private List<Environment> environments;
}
