package com.meli.tucasita.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
@AllArgsConstructor
public class ErrorDto {
  private String name;
  private Map<String, String> errors;

  public ErrorDto() {
    this.errors = new HashMap<>();
  }
}
