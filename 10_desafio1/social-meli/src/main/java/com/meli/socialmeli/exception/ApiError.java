package com.meli.socialmeli.exception;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String error;
    private String message;
}
