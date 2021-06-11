package com.digitalhouse.obtenerdiploma.Exception;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDTOString {
    private String name;
    private String message;

    public ErrorDTOString(String message, String nameClass){
        this.message = message;
        this.name = nameClass;
    }

}
