package com.example.diploms.Services;

import com.example.diploms.Services.DTOs.ScoreDTO;
import com.example.diploms.Services.DTOs.StudentDTO;
import com.example.diploms.Services.DTOs.SubjectDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements iStudentService{
    @Override
    public ScoreDTO getAverageScore(StudentDTO student) {

        double scoreAcum = 0.0;
        for (int i = 0; i < student.getSubjects().size(); i++) {
            SubjectDTO subject = student.getSubjects().get(i);
            scoreAcum = scoreAcum + subject.getScore();
        }
        return new ScoreDTO(student, scoreAcum/student.getSubjects().size());
    }
}
