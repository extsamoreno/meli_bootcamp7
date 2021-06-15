package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotEmpty(message = "The name cant be in blank")
    @Pattern(regexp = "[A-Z].*", message = "The name student must start in uppercase")
    @Size(max=50, message = "Max size by name is 50 characters")
    private String studentName;
    private List<@Valid SubjectDTO> subjects;

}
