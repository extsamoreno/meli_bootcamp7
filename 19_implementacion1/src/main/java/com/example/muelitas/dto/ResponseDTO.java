package com.example.muelitas.dto;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {
    private String message;
    private int status;
}
