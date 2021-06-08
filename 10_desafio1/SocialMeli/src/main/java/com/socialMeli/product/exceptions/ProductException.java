package com.socialMeli.product.exceptions;

import com.socialMeli.user.models.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;
}
