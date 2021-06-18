package com.example.demo.exception;

import com.example.demo.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ExistingHouseException extends Exception {
        private ErrorDTO errorDTO;
        private HttpStatus httpStatus;

        public ExistingHouseException (String name) {
            this.errorDTO = new ErrorDTO();
            this.errorDTO.setMessage("La casa con nombre " + name + " ya existe, no puede existir dos casa con el mismo nombre");
            this.errorDTO.setName(this.getClass().getSimpleName());
            this.httpStatus = HttpStatus.BAD_REQUEST;
        }
    }
