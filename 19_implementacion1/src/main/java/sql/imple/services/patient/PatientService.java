package sql.imple.services.patient;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sql.imple.models.Dentist;
import sql.imple.models.Patient;
import sql.imple.models.Schedule;
import sql.imple.models.dto.DentistDTO;
import sql.imple.models.dto.PatientDTO;
import sql.imple.models.dto.ScheduleDTO;
import sql.imple.repositories.IPatientRepository;
import sql.imple.repositories.IScheduleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService{

    IPatientRepository iPatientRepository;
    ModelMapper mapper;

    @Override
    public void createPatient(PatientDTO patientDTO) {
        iPatientRepository.save(mapper.map(patientDTO, Patient.class));
    }

    @Override
    public void deletePatientById(Long id) {
        iPatientRepository.deleteById(id);
    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        iPatientRepository.save(mapper.map(patientDTO, Patient.class));
    }

    @Override
    public List<PatientDTO> findAllPatients() {
        List<Patient> patients = iPatientRepository.findAll();
        return patients.stream().map(patient -> mapper.map(patient, PatientDTO.class)).collect(Collectors.toList());

    }

    @Override
    public PatientDTO findPatientById(Long id) {
        Optional<Patient> item = iPatientRepository.findById(id);
        return item.map(patient -> mapper.map(patient, PatientDTO.class)).orElse(null);

    }
}
