package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CertificateDTO extends StudentDTO {
  private String studentName;
  private String message;
  @Positive(message = "El promedio de las notas no puede ser cero ni negativo")
  private Double averageScore;
  private List<@Valid SubjectDTO> subjects;
}