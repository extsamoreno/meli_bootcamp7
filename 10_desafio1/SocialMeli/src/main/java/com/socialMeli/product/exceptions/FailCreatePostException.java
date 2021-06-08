package com.socialMeli.product.exceptions;

import com.socialMeli.user.models.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FailCreatePostException extends ProductException {
    public FailCreatePostException(){
        super(new ErrorDTO("Fail Create Post Exception", "Fallo la creacion del post "), HttpStatus.BAD_REQUEST);
    }
}
