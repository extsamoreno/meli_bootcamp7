package com.example.diploms.Services;

import com.example.diploms.Services.DTOs.ScoreDTO;
import com.example.diploms.Services.DTOs.StudentDTO;

public interface iStudentService {

    public ScoreDTO getAverageScore(StudentDTO student);

}
