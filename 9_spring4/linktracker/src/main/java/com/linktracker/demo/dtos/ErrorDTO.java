package com.linktracker.demo.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String message;
    private String name;
}