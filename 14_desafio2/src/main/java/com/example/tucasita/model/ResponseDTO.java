package com.example.tucasita.model;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {
    int status;
    String message;
}
