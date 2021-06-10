package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.Calendar;
import java.util.Date;
@Data
public class InvalidDiscountException extends Exception{
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public InvalidDiscountException (Double discount) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage(discount+" de descuento es invalido, el descuento debe ser menor a 1 o al 100%");
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

}
