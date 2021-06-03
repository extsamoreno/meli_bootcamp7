package boorcamp.spring.dos.demo.controller;


import boorcamp.spring.dos.demo.services.EdadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edades")
public class EdadesController {

    @Autowired
    EdadServices edadServices;

    @GetMapping("calcular/{day}/{month}/{year}")
    public ResponseEntity<Integer> getYears(@PathVariable Integer day,@PathVariable Integer month,@PathVariable Integer year){
        try{
            return new ResponseEntity<>(edadServices.getYears(day,month,year), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
