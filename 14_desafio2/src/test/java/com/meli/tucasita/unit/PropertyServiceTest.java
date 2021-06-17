package com.meli.tucasita.unit;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.repository.PropertyRepository;
import com.meli.tucasita.service.PropertyServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

  @Mock
  private PropertyRepository propertyRepository;

  @InjectMocks
  private PropertyServiceImpl propertyService;

  @Test
  void testCalculatePropertyArea () {
    // Arrange
    Property testProperty = Utils.getPropertyDto();
    int id = testProperty.getId(); // id = 18
    Double expectedArea = 0.00;
    for (EnvironmentDto e: testProperty.getEnvironments()) {
      expectedArea += e.getLength() * e.getWidth();
    }

    when(propertyRepository.findPropertyById(id)).thenReturn(testProperty);


    // Act
    Double currentArea =  propertyService.getPropertyArea(id);

    // Assert
    verify(propertyRepository, times(1)).findPropertyById(id);
    Assertions.assertThat(expectedArea).isEqualTo(currentArea);
  }

}
