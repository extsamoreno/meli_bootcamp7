package com.meli.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

  @NotEmpty(message = "The studentName required")
  @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "The studentName need start with a Capital Letter")
  @Size(max = 30, message = "StudentName soo Long, Max 30 characters")
  private String name;

  @Min(value = 0, message = "Error!, The score min value is 0")
  @Max(value = 10, message = "Error!, The score max value is 10")
  @NotNull(message = "The score required")
  private Integer score;
}
