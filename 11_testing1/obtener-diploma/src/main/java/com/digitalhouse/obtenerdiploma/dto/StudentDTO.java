package com.digitalhouse.obtenerdiploma.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {

    @Size(min = 1, max = 50, message = "Maximum length 50 characters.")
    @NotNull(message = "The name must not be null.")
    @Pattern(regexp = "^[A-Z].*[a-z]$", message="The first letter of the name must be capitalized.")
    private String name;

    @NotNull(message = "The sujects must not be null")
    @Size(min = 1, max = 10, message = "Minimum length of subjects is 1, and maximun 10 subjects.")
    @Valid
    private List<SubjectDTO> subjects;

}
