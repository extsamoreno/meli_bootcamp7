package muelitas1.demo.controller;

import lombok.AllArgsConstructor;
import muelitas1.demo.model.DTO.DentistDTOCreate;
import muelitas1.demo.model.DTO.DentistDTORead;
import muelitas1.demo.model.DTO.DentistDTOUpdate;
import muelitas1.demo.service.IDentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dentist")
public class DentistController {
    IDentistService iDentistService;

    @GetMapping("")
    public List<DentistDTORead> getDentists(){
        return iDentistService.getDentists();
    }

    @PostMapping("")
    public DentistDTORead createDentist(@RequestBody DentistDTOCreate dentistDTOCreate){
        return iDentistService.createDentist(dentistDTOCreate);
    }

    @PutMapping("")
    public DentistDTORead updateDentist(@RequestBody DentistDTOUpdate dentistDTOUpdate){
        return iDentistService.updateDentist(dentistDTOUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable long id){
        iDentistService.deleteDentist(id);
        return ResponseEntity.ok(null);
    }
}
