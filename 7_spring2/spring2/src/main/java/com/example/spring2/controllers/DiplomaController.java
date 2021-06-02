package com.example.spring2.controllers;

import com.example.spring2.classes.*;
import com.example.spring2.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {
    private ArrayList<Student> studentList = new ArrayList<>();

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO studentDTO) {
        Student s = new Student(studentDTO);
        studentList.add(s);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @PostMapping("/{studentName}/add/subject")
    public ResponseEntity<Subject> addSubject(@PathVariable String studentName,
                                              @RequestBody Subject subject) {
        Student s = getStudentByName(studentName);
        Subject sub = new Subject(subject.getName(), subject.getQualification());
        s.getSubjects().add(sub);
        return new ResponseEntity(sub, HttpStatus.CREATED);
    }

    @PostMapping("/{studentName}/add/subjects")
    public ResponseEntity<Subject[]> addSubjects(@PathVariable String studentName,
                                              @RequestBody Subject[] subject) {
        Student s = getStudentByName(studentName);
        for (Subject sub : subject) {
            s.getSubjects().add(new Subject(sub.getName(), sub.getQualification()));
        }
        return new ResponseEntity(s.getSubjects(), HttpStatus.CREATED);
    }

    @GetMapping("/{studentName}")
    public ResponseEntity<Diploma> addSubject(@PathVariable String studentName) {
        Student s = getStudentByName(studentName);
        Diploma d = new Diploma(getAverage(s), studentName);
        return new ResponseEntity(d, HttpStatus.OK);
    }

    private Student getStudentByName(String name) {
        for (Student s : studentList) {
            if(s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    private double getAverage(Student s) {
        double average = 0;
        for (Subject sub : s.getSubjects()) {
            average += sub.getQualification();
        }
        return (average / s.getSubjects().size());
    }
}
