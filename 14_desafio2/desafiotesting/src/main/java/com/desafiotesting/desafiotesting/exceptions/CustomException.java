package com.desafiotesting.desafiotesting.exceptions;
import com.desafiotesting.desafiotesting.services.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

        private final ErrorDTO error;
        private final HttpStatus status;

        public CustomException(String message, HttpStatus status) {
            this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
            this.status = status;
        }

    }
