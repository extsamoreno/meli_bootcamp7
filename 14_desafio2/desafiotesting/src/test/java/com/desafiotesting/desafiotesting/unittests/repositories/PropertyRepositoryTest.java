package com.desafiotesting.desafiotesting.unittests.repositories;
import com.desafiotesting.desafiotesting.exceptions.PropertyNotFoundException;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.repositories.IPropertyRepository;
import com.desafiotesting.desafiotesting.repositories.PropertyRepository;
import com.desafiotesting.desafiotesting.utils.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryTest {

    private IPropertyRepository propertyRepository;

    @BeforeEach
    void init() {
        propertyRepository = new PropertyRepository();
    }

    @Test
    public void saveTest(){
        Property property = TestUtilGenerator.getProperty("District1");

        propertyRepository.save(property);

        Assertions.assertEquals(property,propertyRepository.findById(property.getId()));
    }

    @Test
    public void findByIdThrowExceptionTest(){
        int id = 1;

        PropertyNotFoundException exception = Assertions.assertThrows(PropertyNotFoundException.class, () -> {
            propertyRepository.findById(id);
        });

        String expectedMessage = "La propiedad con el id  " + id + " no existe";
        String actualMessage = exception.getError().getDescription();

        Assertions.assertEquals(expectedMessage,actualMessage);
    }

}
