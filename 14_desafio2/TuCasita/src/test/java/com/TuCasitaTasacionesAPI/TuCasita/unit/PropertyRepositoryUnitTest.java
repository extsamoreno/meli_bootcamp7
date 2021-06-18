package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryUnitTest {

    PropertyRepository propertyRepository = new PropertyRepository();


    @Test
    public void getByIdWithIdValid(){
        Property expected = UtilsDataTests.generateProperty2();
        int id = propertyRepository.create(expected);
        expected.setProp_id(id);

        Property received = propertyRepository.getById(id);

        assertEquals(expected, received);

        propertyRepository.delete(id);
    }

    @Test
    public void getByIdWithIdInvalid() throws PropertyNotFoundException {
        assertEquals(null, propertyRepository.getById(-1));
    }






}
