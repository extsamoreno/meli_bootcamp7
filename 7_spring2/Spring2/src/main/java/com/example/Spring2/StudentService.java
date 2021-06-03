package com.example.Spring2;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public ResponseStudentDTO calcStudent(Student st){

        double totalGrades = 0, average = 0;

        for (Subject s : st.getListSubject()) {
            totalGrades += s.getGrade();
        }
        average = totalGrades/ st.getListSubject().size();
        return new ResponseStudentDTO(st.getName(), average, message(average));

    }

    public String message(double avg){
        if(avg >= 9){
            return "FELICITACIONES!!";
        }
        else{
            return "Bien!";
        }
    }
}
