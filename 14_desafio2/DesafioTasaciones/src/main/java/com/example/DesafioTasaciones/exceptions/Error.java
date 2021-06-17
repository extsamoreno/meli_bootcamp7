package com.example.DesafioTasaciones.exceptions;

import lombok.*;

@Data
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Error {
    private String error;
    private String message;
}
