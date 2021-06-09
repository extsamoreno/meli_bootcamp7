package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import com.socialMeli.repository.SocialMeliRepository;
import org.springframework.http.HttpStatus;

public class FailUploadDatabase extends SocialMeliException {
    public FailUploadDatabase(String fileName){
        super(new ErrorDTO("Fail Load Database Exception", "Fallo la carga del archivo " + fileName), HttpStatus.BAD_REQUEST);
    }
}
