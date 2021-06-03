package com.spring2.spring2.Controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring2.spring2.Classes.Assignature;
import com.spring2.spring2.Classes.House;
import com.spring2.spring2.Classes.Room;
import com.spring2.spring2.Classes.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private HashMap<String, Student> studentMap = new HashMap<>();

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentMap.put(student.getName(),student);

        return new ResponseEntity(student, HttpStatus.CREATED);
    }

    @PostMapping("/{studentName}/assignature")
    public ResponseEntity<String> addAssignature(@PathVariable String studentName,
                                                 @RequestBody Assignature assignature){
        Student student = studentMap.get(studentName);
        student.getAssignatures().add(assignature);
        studentMap.put(studentName, student);
        return new ResponseEntity(studentName, HttpStatus.CREATED);
    }

    @GetMapping("/diploma/{studentName}")
    public ResponseEntity<String> getStudentDiploma(@PathVariable String studentName) {
        Student s = studentMap.get(studentName);
        List<Assignature> assignatures = s.getAssignatures();
        double average = 0;
        for (Assignature a : assignatures) {
            average += a.getScore();
        }
        average = average / assignatures.size();

        if (average > 9) {
            return new ResponseEntity<>("Felicitaciones " + studentName + ", tu promedio fue " + average, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( studentName + ", tu promedio fue " + average, HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<Student> GetAllStudent() {
        return new ResponseEntity(studentMap.values(), HttpStatus.OK);
    }
}
