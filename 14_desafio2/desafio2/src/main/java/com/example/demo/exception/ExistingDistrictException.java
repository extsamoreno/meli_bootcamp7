package com.example.demo.exception;

import com.example.demo.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class ExistingDistrictException extends Exception {
        private ErrorDTO errorDTO;
        private HttpStatus httpStatus;
        public ExistingDistrictException (String name) {
            this.errorDTO = new ErrorDTO();
            this.errorDTO.setMessage("El barrio " + name + " ya existe");
            this.errorDTO.setName(this.getClass().getSimpleName());
            this.httpStatus = HttpStatus.BAD_REQUEST;
        }
    }
