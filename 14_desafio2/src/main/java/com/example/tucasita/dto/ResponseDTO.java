package com.example.tucasita.dto;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {
    int status;
    String message;
}
