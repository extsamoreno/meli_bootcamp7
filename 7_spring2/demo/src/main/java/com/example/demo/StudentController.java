package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/degree")
public class StudentController {
    @PostMapping("/student")
    public ResponseEntity<StudentDTO> getDegree(@RequestBody Student student){
        double average = student.average();
        String message = "Se le otroga el titulo. ";
        if (average>9.0)
            message += "Felicitaciones obtuvo promedio mayor a 9.0";
        StudentDTO studentDTO =  new StudentDTO(message,average,student.getName());
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity(studentDTO, HttpStatus.OK);
        return responseEntity;
    }
}
