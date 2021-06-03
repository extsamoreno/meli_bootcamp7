package com.spring2.spring2.Controllers;

import com.spring2.spring2.Classes.Assignature;
import com.spring2.spring2.Classes.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignature")
public class AssignatureController {

    @PostMapping("/create")
    public ResponseEntity<Assignature> createAssignature(@RequestBody Assignature assignature){

        return new ResponseEntity(new Assignature(assignature.getName(), assignature.getScore()), HttpStatus.CREATED);

    }

}
