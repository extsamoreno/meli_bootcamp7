package com.testingchallenge.tucasita.exception;

import com.testingchallenge.tucasita.dto.ErrorDTO;
import com.testingchallenge.tucasita.model.Neighborhood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NeighborhoodException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public NeighborhoodException (String message, HttpStatus status) {
        error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}
