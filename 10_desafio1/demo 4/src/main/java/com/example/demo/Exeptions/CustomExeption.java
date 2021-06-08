package com.example.demo.Exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExeption extends Exception{

    private HttpStatus status;
    private String errorMessage;


}
