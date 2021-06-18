package com.example.demo.exception;

import com.example.demo.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class HouseNotFoundException extends Exception{
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public HouseNotFoundException (String name) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage("La casa con nombre " + name + " no ha sido encontrada por favor agregarla");
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
