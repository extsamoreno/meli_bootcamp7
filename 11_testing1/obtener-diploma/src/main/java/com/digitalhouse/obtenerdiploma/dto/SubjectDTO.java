package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDTO {

  @NotNull
  @Pattern(regexp = "^[A-Z].*[a-z]$", message="The first letter of the subject must be capitalized.")
  @Size(min = 1, max = 30, message = "Maximum length 50 characters.")
  private String subject;

  @NotNull
  @PositiveOrZero(message = "The value must be positive.")
  @Min(value = 0, message = "Minimun value 0.0")
  @Max(value = 10, message = "Maximun value 10.0")
  private Integer note;

}
