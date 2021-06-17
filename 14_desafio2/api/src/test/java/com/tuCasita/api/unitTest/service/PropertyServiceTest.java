package com.tuCasita.api.unitTest.service;

import com.tuCasita.api.dto.DistrictDTO;
import com.tuCasita.api.dto.PropertyDTO;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import com.tuCasita.api.repository.contract.IPropertyRepository;
import com.tuCasita.api.service.implementation.PropertyService;
import com.tuCasita.api.testUtil.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    IPropertyRepository repository;

    @InjectMocks
    PropertyService service;

    @Test
    public void getTotalSquareMetersWithValidDTOShouldReturnValidDTO() throws DistrictNameNotFoundException {
        //Arrange
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        var expected = TestUtil.getPropertyWithTotalSquareMeters();
        when(repository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());

        //Act
        var result = service.getTotalSquareMeters(dto);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void getTotalSquareMetersWithInvalidDistrictShouldThrowException() throws DistrictNameNotFoundException {
        //Arrange
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        when(repository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());
        dto.setDistrict(new DistrictDTO("IncorrectDistrictName", 10.0));

        //Act

        //Assert
        assertThrows(DistrictNameNotFoundException.class, () -> service.getTotalSquareMeters(dto));
    }

    @Test
    public void getTotalValueWithValidDTOShouldReturnValidDTO() throws DistrictNameNotFoundException{
        //Arrange
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        when(repository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());
        var expected = TestUtil.getPropertyWithTotalValue();

        //Act
        var result = service.getTotalValue(dto);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void calculateBiggestEnvironmentShouldReturnValidDTO() throws DistrictNameNotFoundException {
        //Arrange
        var dto = TestUtil.getPropertyDTOWith3EnvironmentsOneBiggest();
        when(repository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());
        var expected = TestUtil.getPropertyWithBiggestEnvironment();

        //Act
        var result = service.calculateBiggestEnvironment(dto);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void getTotalSquareMetersByEnvironmentShouldReturnValidDTO() throws DistrictNameNotFoundException {
        //Arrange
        var dto = TestUtil.getPropertyDTOWith3Environments();
        when(repository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());
        var expected = TestUtil.getPropertyWithTotalSquareMetersByEnvironment();

        //Act
        var result = service.getTotalSquareMetersByEnvironment(dto);

        //Assert
        assertEquals(expected, result);
    }

}
