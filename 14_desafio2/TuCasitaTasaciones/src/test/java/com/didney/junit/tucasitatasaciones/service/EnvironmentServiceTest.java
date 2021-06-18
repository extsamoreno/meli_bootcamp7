package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.mapper.EnvironmentMapper;
import com.didney.junit.tucasitatasaciones.model.Environment;
import com.didney.junit.tucasitatasaciones.repository.IEnvironmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnvironmentServiceTest {

    @Mock
    IEnvironmentRepository iEnvironmentRepository;

    @Mock
    EnvironmentMapper environmentMapper;

    @InjectMocks
    EnvironmentService environmentService;

    @Test
    void addEnvironment() {
        //arrange
        EnvironmentDTO expected = getEnvironmentDTO();
        EnvironmentDTO property = getEnvironmentDTO();
        when(environmentMapper.environmentDTOToEnvironment(getEnvironmentDTO())).thenReturn(getEnvironments());
        when(iEnvironmentRepository.addEnvironment(getEnvironments())).thenReturn(getEnvironments());
        when(environmentMapper.environmentToEnvironmentDTO(getEnvironments())).thenReturn(property);
        //act
        EnvironmentDTO received = environmentService.addEnvironment(getEnvironmentDTO());
        //assert
        verify(environmentMapper, atLeast(1)).environmentDTOToEnvironment(getEnvironmentDTO());
        verify(iEnvironmentRepository, atLeast(1)).addEnvironment(getEnvironments());
        verify(environmentMapper, atLeast(1)).environmentToEnvironmentDTO(getEnvironments());
        assertEquals(expected, received);
    }

    @Test
    void addEnvironments() {
        //arrange
        List<EnvironmentDTO> expected = new ArrayList<>();
        expected.add(getEnvironmentDTO());
        expected.add(getEnvironmentDTO());
        List<EnvironmentDTO> listSend = new ArrayList<>();
        listSend.add(getEnvironmentDTO());
        listSend.add(getEnvironmentDTO());
        EnvironmentDTO property = getEnvironmentDTO();
        when(environmentMapper.environmentDTOToEnvironment(getEnvironmentDTO())).thenReturn(getEnvironments());
        when(iEnvironmentRepository.addEnvironment(getEnvironments())).thenReturn(getEnvironments());
        when(environmentMapper.environmentToEnvironmentDTO(getEnvironments())).thenReturn(property);
        //act
        List<EnvironmentDTO> received = environmentService.addEnvironments(listSend);
        //assert
        verify(environmentMapper, atLeast(listSend.size())).environmentDTOToEnvironment(getEnvironmentDTO());
        verify(iEnvironmentRepository, atLeast(listSend.size())).addEnvironment(getEnvironments());
        verify(environmentMapper, atLeast(listSend.size())).environmentToEnvironmentDTO(getEnvironments());
        assertEquals(expected, received);
    }

    @Test
    void getEnvironment() {
        //arrange
        List<Environment> propertyList = new ArrayList<>();
        propertyList.add(getEnvironments());
        propertyList.add(getEnvironments());
        List<EnvironmentDTO> expected = new ArrayList<>();
        expected.add(getEnvironmentDTO());
        expected.add(getEnvironmentDTO());
        when(iEnvironmentRepository.getEnvironment()).thenReturn(propertyList);
        when(environmentMapper.environmentToListEnvironmentDTO(propertyList)).thenReturn(expected);
        //act
        List<EnvironmentDTO> received = environmentService.getEnvironment();
        //assert
        verify(iEnvironmentRepository, atLeast(1)).getEnvironment();
        assertEquals(expected, received);
    }

    private EnvironmentDTO getEnvironmentDTO() {
        return new EnvironmentDTO("Environment 1", 15, 18);
    }

    private Environment getEnvironments() {
        return new Environment(1, "Environment 1", 15, 18);
    }
}