package sql.imple.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sql.imple.models.Patient;
import sql.imple.models.dto.DentistDTO;
import sql.imple.models.dto.PatientDTO;
import sql.imple.services.dentist.IDentistService;
import sql.imple.services.patient.IPatientService;

import java.util.List;

@RestController
@RequestMapping("patient")
@AllArgsConstructor
public class PatientController {

    IPatientService iPatientService;

    @PostMapping("/create")
    public String createPatient(@RequestBody PatientDTO patientDTO){
        iPatientService.createPatient(patientDTO);
        return "Patient created correctly";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        iPatientService.deletePatientById(id);
        return "Patient deleted correctly";
    }

    @PutMapping("/update")
    public String updatePatient(@RequestBody PatientDTO patientDTO) {
        iPatientService.updatePatient(patientDTO);
        return "Patient updated correctly";
    }

    @GetMapping("/getAll")
    public List<PatientDTO> getAllPatient() {
        return iPatientService.findAllPatients();
    }

    @GetMapping("/getPatient/{id}")
    public PatientDTO getPatient(@PathVariable Long id) {
        return iPatientService.findPatientById(id);
    }


}
