package com.socialMeli.user.exceptions;

import com.socialMeli.user.models.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;
}
