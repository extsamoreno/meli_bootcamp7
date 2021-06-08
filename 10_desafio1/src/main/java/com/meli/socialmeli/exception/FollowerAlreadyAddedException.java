package com.meli.socialmeli.exception;

import com.meli.socialmeli.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FollowerAlreadyAddedException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public FollowerAlreadyAddedException(){
        this.errorDTO = new ErrorDTO("ERROR: This user has been already added as a follower of this merchant", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
