package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryUnitTest {

    PropertyRepository propertyRepository = new PropertyRepository();

    @Test
    public void createHappyPath(){



    }

    @Test
    public void getByIdWithIdValid() throws PropertyNotFoundException {
        Property expected = UtilsDataTests.generateProperty();

        Property received = propertyRepository.getById(1);

        assertEquals(expected, received);
    }

    @Test
    public void getByIdWithIdInvalid() throws PropertyNotFoundException {
        assertThrows(PropertyNotFoundException.class, () -> propertyRepository.getById(-1));
    }






}
