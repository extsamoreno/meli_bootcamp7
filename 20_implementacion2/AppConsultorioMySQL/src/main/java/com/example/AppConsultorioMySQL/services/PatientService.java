package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.PatientNotFoundException;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;
import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements  IPatientService{
    IPatientRepository patientRepository;
    ModelMapper mapper;

    @Override
    public String createPatient(PatientDTO patientDTO) {
        patientRepository.save(mapper.map(patientDTO,Patient.class));
        return "Se creó el paciente correctamente";
    }

    @Override
    public String updatePatient(PatientDTO patientDTO) throws PatientNotFoundException {
        Optional<Patient> item = patientRepository.findById(patientDTO.getId());

        if (item == null){
            throw new PatientNotFoundException(item);
        }

        patientRepository.save(mapper.map(patientDTO, Patient.class));
        return "Se Actualizó correctamente el paciente " + patientDTO.getName();
    }

    @Override
    public String deletePatient(Long id) throws PatientNotFoundException {
        Optional<Patient> item = patientRepository.findById(id);

        if (item == null){
            throw new PatientNotFoundException(item);
        }

        patientRepository.deleteById(id);

        return "Se eliminó correctamente el paciente " + id;
    }

    @Override
    public List<PatientDTO> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(patient -> mapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO findPatientById(Long id) throws PatientNotFoundException {
        Optional<Patient> item = patientRepository.findById(id);

        if (item == null){
            throw new PatientNotFoundException(item);
        }

        return item.map(patient -> mapper.map(patient, PatientDTO.class)).orElse(null);
    }

    @Override
    public List<PatientDTO> listPatientsByDate(LocalDate date) {
        List<Patient> item = patientRepository.listPatientsByDate(date);

        return item.stream().map(patient -> mapper.map(patient,PatientDTO.class)).collect(Collectors.toList());
    }
}
