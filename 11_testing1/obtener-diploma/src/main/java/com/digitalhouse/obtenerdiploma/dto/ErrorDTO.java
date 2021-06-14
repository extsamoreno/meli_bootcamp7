package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
  private String name;
  private Map<String, String> errors;

  public ErrorDTO() {
    this.errors = new HashMap<>();
  }
}
