package com.example.ApiSpring2;

import com.example.ApiSpring2.dtos.ErrorDto;
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
    private ArrayList<ErrorDto> errors;
    private HttpStatus status;

    public ValidationException(BindingResult bindingResult){
        errors = new ArrayList<>();
        ErrorDto error = new ErrorDto();
        for (ObjectError ex:bindingResult.getAllErrors()) {
            error.setName(ex.getObjectName());
            error.setMessage(ex.getDefaultMessage());
            errors.add(error);
        }
        this.status = HttpStatus.BAD_REQUEST;
    }
}
