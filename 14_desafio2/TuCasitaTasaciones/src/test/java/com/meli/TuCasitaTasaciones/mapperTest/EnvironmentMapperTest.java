package com.meli.TuCasitaTasaciones.mapperTest;

import com.meli.TuCasitaTasaciones.mapper.EnvironmentMapper;
import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;
import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class EnvironmentMapperTest {

    @Test
    public void ToEnvironmentAreaResponseDTOTest() {
         //arrange
        EnvironmentDTO environmentDTO = TestUtilsGenerator.getEnvironmentDTO();
        EnvironmentAreaResponseDTO expected = TestUtilsGenerator.getEnvironmentAreaResponseDTO();

        // act
        EnvironmentAreaResponseDTO received = EnvironmentMapper.ToEnvironmentAreaResponseDTO(environmentDTO);

        // assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void ToEnvironmentDTOTest() {
        //arrange
        EnvironmentDTO expected = TestUtilsGenerator.getEnvironmentDTO();
        EnvironmentAreaResponseDTO environmentAreaResponseDTO  = TestUtilsGenerator.getEnvironmentAreaResponseDTO();

        // act
        EnvironmentDTO received = EnvironmentMapper.ToEnvironmentDTO(environmentAreaResponseDTO);

        // assert
        Assertions.assertEquals(expected, received);
    }
}
