package com.example.muelitas.service;

import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.model.Professional;
import com.example.muelitas.repository.ProfessionalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessionalServiceImple implements ProfessionalService{

    @Autowired
    ProfessionalRepository professionalRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDTO createProfessional(ProfessionalDTO newProfessional) {
        ResponseDTO response = new ResponseDTO();

        professionalRepository.save(modelMapper.map(newProfessional, Professional.class));

        response.setMessage("A new professional was created");
        response.setStatus(201);
        return response;
    }

    @Override
    public ProfessionalDTO readProfessional(Long idProfessional) {
        ProfessionalDTO responseProfessional;
        Optional<Professional> dbProfessional;

        dbProfessional = professionalRepository.findById(idProfessional);

        responseProfessional = modelMapper.map(dbProfessional.get(), ProfessionalDTO.class);
        return responseProfessional;
    }

    @Override
    public ResponseDTO updateProfessional(ProfessionalDTO updatedProfessional) {
        ResponseDTO response = new ResponseDTO();

        professionalRepository.save(modelMapper.map(updatedProfessional, Professional.class));

        response.setMessage("An existing professional was updated");
        response.setStatus(200);
        return response;
    }

    @Override
    public ResponseDTO deleteProfessional(Long idProfessional) {
        ResponseDTO response = new ResponseDTO();

        professionalRepository.deleteById(idProfessional);

        response.setMessage("A professional was deleted");
        response.setStatus(200);
        return response;
    }
}
