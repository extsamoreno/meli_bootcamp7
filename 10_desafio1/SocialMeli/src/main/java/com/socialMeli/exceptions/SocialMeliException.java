package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SocialMeliException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;
}
