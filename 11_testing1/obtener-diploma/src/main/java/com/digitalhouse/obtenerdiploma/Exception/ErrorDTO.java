package com.digitalhouse.obtenerdiploma.Exception;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDTO{
    private String name;
    private ArrayList<ErrorNameDTO> errosTypeName = new ArrayList<>();

    public ErrorDTO(List<ObjectError> erros, String nameClass){
        this.name = nameClass;
        loadErros(erros);
    }

    private void loadErros(List<ObjectError> erros) {
        for (ObjectError error: erros) {
            ErrorNameDTO errorType = new ErrorNameDTO(error.getObjectName(), error.getDefaultMessage());
            if (!errosTypeName.contains(errorType)) {
                errosTypeName.add(errorType);
            }
        }
    }
}
