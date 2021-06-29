package com.meli.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentsDTO {

    int totalCount;
    int page;
    int pageSize;
    List<StudentDTO> students;

    public StudentsDTO() {
        students = new ArrayList();
    }
}
