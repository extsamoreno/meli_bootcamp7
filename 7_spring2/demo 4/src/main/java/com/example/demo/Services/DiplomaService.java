package com.example.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class DiplomaService {


    public DiplomaResponseDTO getDiplomaDTO(Student student){

        DiplomaResponseDTO diplomaResponseDTO = new DiplomaResponseDTO();

        diplomaResponseDTO.setStudentName(student.getName());
        diplomaResponseDTO.setAverage(getAverage(student));
        diplomaResponseDTO.setMessage(setMessage(getAverage(student)));

        return diplomaResponseDTO;
    }


    public int getAverage(Student student){
        int average =0;

        for(int i=0; i<student.getCourses().size();i++){
            average += student.getCourses().get(i).getNote();
        }

        return average / student.getCourses().size();
    }

    public String setMessage(int note){
       String message = "Su diploma ";
       if(note > 9 ) {
           message = "Felicitaciones su diploma es muy bueno ";
       }
       return message;
    }
}
