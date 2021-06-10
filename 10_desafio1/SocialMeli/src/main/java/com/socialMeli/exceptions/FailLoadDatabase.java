package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

/**
 * Thrown if the load of the data in the .json can not be completed for any reason
 */
public class FailLoadDatabase extends SocialMeliException{
    public FailLoadDatabase(String fileName){
        super(new ErrorDTO("Fail Load Database Exception", "Fallo la carga del archivo " + fileName), HttpStatus.BAD_REQUEST);
    }
}
