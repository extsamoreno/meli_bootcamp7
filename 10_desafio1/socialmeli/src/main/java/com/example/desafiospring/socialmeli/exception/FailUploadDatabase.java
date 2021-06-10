package com.example.desafiospring.socialmeli.exception;

import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FailUploadDatabase extends SocialMeliException {
    public FailUploadDatabase(String fileName){
        super(new ErrorDTO("Fail Load Database Exception",+ fileName), HttpStatus.BAD_REQUEST);
    }
}
