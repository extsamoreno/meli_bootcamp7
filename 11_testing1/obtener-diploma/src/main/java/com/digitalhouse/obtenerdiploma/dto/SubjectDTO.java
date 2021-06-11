package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
  @NotEmpty(message = "The name cant be in blank")
  @Pattern(regexp = "[A-Z].*", message = "The name subject must start in uppercase")
  @Size(max=30, message = "Max size by name is 30 characters")
  private String name;

  @NotNull(message = "The score cant be null")
  @DecimalMin(value = "0.0", message = "Score min is 0.0")
  @DecimalMax(value = "10.0", message = "Score max is 10.0")
  private double score;

}
