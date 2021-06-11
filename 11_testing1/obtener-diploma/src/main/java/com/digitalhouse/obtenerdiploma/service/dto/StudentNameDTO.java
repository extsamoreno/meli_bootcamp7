package com.digitalhouse.obtenerdiploma.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class StudentNameDTO extends StudentDTO {

    private String studentName;

    public void setStudentName(String studentName) {
        super.setName(studentName);
    }
}
