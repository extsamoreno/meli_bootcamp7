package com.meli.calculatorHouseSquareMeters.model.exception;

import com.meli.calculatorHouseSquareMeters.model.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CalculatorHouseException extends  Exception{
    private final ErrorDTO error;
    private final HttpStatus status;

    public CalculatorHouseException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }

}
