package com.appconsultorio.appconsultorio.controller;
import com.appconsultorio.appconsultorio.dtos.request.DentistDTO;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.service.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("dentist")
@AllArgsConstructor
public class DentistController {

    IDentistService iDentistService;

    @PostMapping("/create")
    public String loadDentist(@RequestBody DentistDTO dentistDTO){
        iDentistService.createDentist(dentistDTO);
        return "Odontologo creado correctamente";
    }

    @PostMapping("/edit")
    public String editDentist(@RequestBody DentistDTO dentistDTO){
        iDentistService.updateDentist(dentistDTO);
        return "Odontologo editado correctamente";
    }

    @PostMapping("/remove")
    public String removeDentist(@RequestParam int id){
        iDentistService.removeDentist(id);
        return "Odontologo eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Dentist> getDentists(){
        return iDentistService.getDentist();
    }
}
