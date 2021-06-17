package com.meli.tucasita.unit;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.repository.PropertyRepository;
import com.meli.tucasita.service.PropertyServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

  @Mock
  private PropertyRepository propertyRepository;

  @InjectMocks
  private PropertyServiceImpl propertyService;

  @Test
  void testGetPropertyArea () {
    // Arrange
    PropertyDto testProperty = Utils.getPropertyDto();
    int id = testProperty.getId(); // id = 18
    double area = 0.00;
    for (EnvironmentDto e: testProperty.getEnvironments()) {
      area += e.getLength() * e.getWidth();
    }
    PropertyAreaDto expectedPropertyAreaDto = new PropertyAreaDto(testProperty.getName(), area);
    when(propertyRepository.findPropertyById(id)).thenReturn(testProperty);

    // Act
    PropertyAreaDto currentPropertyAreaDto =  propertyService.getPropertyArea(id);

    // Assert
    verify(propertyRepository, times(1)).findPropertyById(id);
    Assertions.assertThat(expectedPropertyAreaDto).isEqualTo(currentPropertyAreaDto);
  };

  @Test
  void testGetBiggestEnvironment () {
    // Arrange
    PropertyDto testProperty = Utils.getPropertyDto();
    int id = testProperty.getId(); // id = 18
    double area = 0.00;
    double maxArea = 0.00;
    String maxEnvironment = "";
    for (EnvironmentDto e: testProperty.getEnvironments()) {
      area = e.getLength() * e.getWidth();
      if (area > maxArea) {
        maxArea = area;
        maxEnvironment = e.getName();
      }
    }
    EnvironmentAreaDto expectedBiggestEnvironment = new EnvironmentAreaDto(maxEnvironment, maxArea);
    when(propertyRepository.findPropertyById(id)).thenReturn(testProperty);

    // Act
    EnvironmentAreaDto currentBiggestEnvironment = propertyService.getBiggestEnvironment(id);

    // Arrange
    verify(propertyRepository, times(1)).findPropertyById(id);
    Assertions.assertThat(expectedBiggestEnvironment).isEqualTo(currentBiggestEnvironment);
  }

  @Test
  void testGetPropertyEnvironments () {
    // Assert
    PropertyDto testProperty = Utils.getPropertyDto();
    int id = testProperty.getId();
    List<EnvironmentAreaDto> expectedEnvironments = new ArrayList<>();
    for (EnvironmentDto e: testProperty.getEnvironments()) {
      expectedEnvironments.add(new EnvironmentAreaDto(e.getName(), e.getLength()*e.getWidth()));
    }
    when(propertyRepository.findPropertyById(id)).thenReturn(testProperty);

    // Act
    List<EnvironmentAreaDto> currentEnvironments = propertyService.getPropertyEnvironments(id);

    // Arrange
    verify(propertyRepository, times(1)).findPropertyById(id);
    Assertions.assertThat(expectedEnvironments).isEqualTo(currentEnvironments);
  }
}
