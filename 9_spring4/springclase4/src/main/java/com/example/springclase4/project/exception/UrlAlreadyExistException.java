package com.example.springclase4.project.exception;

import com.example.springclase4.project.repository.DTO.UrlRequestDTO;
import org.springframework.http.HttpStatus;

public class UrlAlreadyExistException extends UrlException{
    public UrlAlreadyExistException(UrlRequestDTO urlRequestDTO) {
        super("El url: "+ urlRequestDTO.getUrl() + " ya existe en la base de datos.", HttpStatus.BAD_REQUEST);
    }

}
