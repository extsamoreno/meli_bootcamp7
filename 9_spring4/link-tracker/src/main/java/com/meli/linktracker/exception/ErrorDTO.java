package com.meli.linktracker.exception;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private String name;
}
