package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Calendar;
import java.util.Date;
@Data
public class InvalidityDateException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public InvalidityDateException (Date date) {
        this.errorDTO = new ErrorDTO();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dateString = calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR);
        this.errorDTO.setMessage("La fecha " + dateString + " es mayor a la fecha actual");
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
