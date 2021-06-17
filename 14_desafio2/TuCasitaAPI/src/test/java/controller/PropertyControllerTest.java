package controller;

import com.meli.tucasita.controller.PropertyController;
import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.IPropertyService;
import com.meli.tucasita.service.dto.PropertyWithM2DTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;



}
