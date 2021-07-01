package sql.imple.services.patient;

import sql.imple.models.dto.DentistDTO;
import sql.imple.models.dto.PatientDTO;

import java.util.List;

public interface IPatientService {
    void createPatient(PatientDTO patientDTO);
    void deletePatientById(Long id);
    List<PatientDTO> findAllPatients();
    PatientDTO findPatientById(Long id);
    void updatePatient(PatientDTO patientDTO);
}
