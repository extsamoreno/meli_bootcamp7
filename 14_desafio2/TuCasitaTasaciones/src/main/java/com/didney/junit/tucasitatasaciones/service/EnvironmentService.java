package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.mapper.EnvironmentMapper;
import com.didney.junit.tucasitatasaciones.repository.IEnvironmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentService implements IEnvironmentService {
    EnvironmentMapper environmentMapper;
    IEnvironmentRepository iEnvironmentRepository;

    public EnvironmentService(EnvironmentMapper environmentMapper, IEnvironmentRepository iEnvironmentRepository) {
        this.environmentMapper = environmentMapper;
        this.iEnvironmentRepository = iEnvironmentRepository;
    }

    @Override
    public EnvironmentDTO addEnvironment(EnvironmentDTO environmentDTO) {
        return environmentMapper.environmentToEnvironmentDTO(iEnvironmentRepository.addEnvironment(environmentMapper.environmentDTOToEnvironment(environmentDTO)));
    }

    @Override
    public List<EnvironmentDTO> addEnvironments(List<EnvironmentDTO> environmentDTOList) {
        List<EnvironmentDTO> response = new ArrayList<>();
        for (EnvironmentDTO obj : environmentDTOList) {
            response.add(addEnvironment(obj));
        }
        return response;
    }

    @Override
    public List<EnvironmentDTO> getEnvironment() {
        return environmentMapper.environmentToListEnvironmentDTO(iEnvironmentRepository.getEnvironment());
    }
}
