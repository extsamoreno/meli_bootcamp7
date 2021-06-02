package com.Spring.clase2.Controllers;

import com.Spring.clase2.Entities.Diploma;
import com.Spring.clase2.Entities.House;
import com.Spring.clase2.Entities.ResponseHouseDTO;
import com.Spring.clase2.Entities.Student;
import com.Spring.clase2.Services.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    private DiplomaService dService = new DiplomaService();

    @PostMapping("/generateDiploma")
    public ResponseEntity<Diploma> calculatePrice(@RequestBody() Student student){
        return new ResponseEntity<>(dService.generateDiploma(student), HttpStatus.OK);
    }

}
