package sql.imple.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sql.imple.services.dentist.IDentistService;
import sql.imple.models.dto.DentistDTO;

import java.util.List;

@RestController
@RequestMapping("dentists")
@AllArgsConstructor
public class DentistController {

    IDentistService iDentistService;

    @PostMapping("/create")
    public String createDentist(@RequestBody DentistDTO dentistDTO){
        iDentistService.createDentist(dentistDTO);
        return "Dentist created correctly";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteDentist(@PathVariable Long id) {
        iDentistService.deleteDentistById(id);
        return "Dentist deleted correctly";
    }

    @PutMapping("/update")
    public String updateDentist(@RequestBody DentistDTO dentist) {
        iDentistService.updateDentist(dentist);
        return "Dentist updated correctly";
    }

    @GetMapping("/getAll")
    public List<DentistDTO> getAllDentist() {
        return iDentistService.findAllDentists();
    }

    @GetMapping("/getDentist/{id}")
    public DentistDTO getDentist(@PathVariable Long id) {
        return iDentistService.findDentistById(id);
    }



}
