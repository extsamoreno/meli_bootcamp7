package com.digitalhouse.obtenerdiploma;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationException extends Exception{
    private ArrayList<ErrorDTO> errors;
    private HttpStatus status;

    public ValidationException(BindingResult bindingResult){
        errors = new ArrayList<>();
        ErrorDTO error = new ErrorDTO();
        for (ObjectError ex:bindingResult.getAllErrors()) {
            error.setNombre(ex.getObjectName());
            error.setMensaje(ex.getDefaultMessage());
            errors.add(error);
        }
        this.status = HttpStatus.BAD_REQUEST;
    }
}
