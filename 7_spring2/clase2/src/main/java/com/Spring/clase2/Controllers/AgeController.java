package com.Spring.clase2.Controllers;

import com.Spring.clase2.Entities.ResponseAgeDTO;
import com.Spring.clase2.Services.AgeService;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
@RequestMapping("/age")
public class AgeController {

    private AgeService aService = new AgeService();

    @GetMapping("/calculateAge/{dateBorn}")
    public ResponseEntity<ResponseAgeDTO> calculateAge(@PathVariable() String dateBorn){
        ResponseAgeDTO resp = new ResponseAgeDTO();
        resp.setAge(aService.calulateAge(dateBorn));

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


}
