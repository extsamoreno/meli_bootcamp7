package com.randomstudent.demo.Controller;
import com.randomstudent.demo.Service.IStudentService;
import com.randomstudent.demo.Model.StudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("students/")
public class StudentController {

    IStudentService iStudentService;

    @GetMapping("/get/exhibitors")
    public ResponseEntity<List<StudentDTO>> getExhibitors(){
        return new ResponseEntity(, HttpStatus.OK);
    }

}
