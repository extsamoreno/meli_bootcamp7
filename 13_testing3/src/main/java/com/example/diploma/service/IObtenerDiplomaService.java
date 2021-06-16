package com.example.diploma.service;

import com.example.diploma.model.StudentDTO;

public interface IObtenerDiplomaService {
    StudentDTO analyzeScores(Long studentId);
}
