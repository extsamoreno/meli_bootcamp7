package com.meli.tucasita.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDto {
  private String message;
  private String name;
}
