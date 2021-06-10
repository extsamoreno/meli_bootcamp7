package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PublicationExistingException extends Exception{
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public PublicationExistingException (int id_post) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage("Ya se ha hecho una publicación con el id " + id_post);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
