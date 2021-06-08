package com.exceptions;

import com.models.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception extends java.lang.Exception {

    private ErrorDTO error;
    private HttpStatus status;
}
