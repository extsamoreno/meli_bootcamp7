package meli.bootcamp.tucasita.unit.repository;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.model.Environment;
import meli.bootcamp.tucasita.model.Property;
import meli.bootcamp.tucasita.repository.IPropertyRepository;

import meli.bootcamp.tucasita.repository.PropertyRepository;
import meli.bootcamp.tucasita.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PropertyRepositoryTest {

    IPropertyRepository propertyRepository;


    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyPropertyFile();
        this.propertyRepository = new PropertyRepository();
    }

    @Test
    public void findByIdExistingProperty() throws PropertyNotFoundException {
        // arrange
        Set<Property> properties = TestUtilsGenerator.getPropertySet();
        properties.forEach((property) -> propertyRepository.save(property));

        Environment environment1 = new Environment("Sala",15.0,13.0);
        Environment environment2 = new Environment("Comedor",25.0,20.3);
        Environment environment3 = new Environment("Patio",15.0,13.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);


        Property expected= new Property("Casa Marco",new District("District test",500),environments);

        // act
        Property foundSet = propertyRepository.findById("Casa Marco");

        // assert
        Assertions.assertEquals(expected, foundSet);
    }

    @Test
    public void DeleteExistingProperty() throws PropertyNotFoundException {
        // arrange
        Set<Property> properties = TestUtilsGenerator.getPropertySet();
        properties.forEach((property) -> propertyRepository.save(property));


        // act
        Boolean found = propertyRepository.delete("Casa Marco");

        // assert
        Assertions.assertTrue(found);
    }

    @Test
    public void findByIdNoExistingProperty() {
        // arrange
        Set<Property> properties = TestUtilsGenerator.getPropertySet();
        properties.forEach((property) -> propertyRepository.save(property));

        Environment environment1 = new Environment("Sala",15.0,13.0);
        Environment environment2 = new Environment("Comedor",25.0,20.3);
        Environment environment3 = new Environment("Patio",15.0,13.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);


        Property expected= new Property("Casa Marco 2",new District("District test",500),environments);

        // act
        try {
            Assertions.assertEquals(expected, propertyRepository.findById("Casa Marco 2"));
            Assertions.fail( "Should have thrown an exception" );
        }
        catch (PropertyNotFoundException e) {
            PropertyNotFoundException expectedException= new PropertyNotFoundException("Casa Marco 2");
            String exceptionMessageExpected="La propiedad con nombre Casa Marco 2 no se encuentra registrada.";
            Assertions.assertEquals( exceptionMessageExpected, e.getError().getDescription() );
        }
    }
}
