package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
