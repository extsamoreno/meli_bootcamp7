package com.meli.socialmeli.exception;

import com.meli.socialmeli.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostIdAlreadyExistsException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public PostIdAlreadyExistsException(){
        this.errorDTO = new ErrorDTO("ERROR: The entered PostId already exists", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
