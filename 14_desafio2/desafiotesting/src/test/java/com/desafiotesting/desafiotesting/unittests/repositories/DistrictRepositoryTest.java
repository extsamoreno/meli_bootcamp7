package com.desafiotesting.desafiotesting.unittests.repositories;
import com.desafiotesting.desafiotesting.exceptions.DistrictNotFoundException;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.repositories.DistrictRepository;
import com.desafiotesting.desafiotesting.repositories.IDistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryTest {

    private IDistrictRepository districtRepository;

    @BeforeEach
    void init() {
        districtRepository = new DistrictRepository();
    }

    @Test
    public void findDistrictByNameFoundTest(){
        String name = "District1";

        District response = districtRepository.findByName(name);

        Assertions.assertEquals(name,response.getName());
    }

    @Test
    public void findDistrictByNameNotFoundTest(){
        String name = "district1";

        DistrictNotFoundException exception = Assertions.assertThrows(DistrictNotFoundException.class, () -> {
           districtRepository.findByName(name);
        });

        String expectedMessage = "El barrio " + name + " no existe";
        String actualMessage = exception.getError().getDescription();

        Assertions.assertEquals(expectedMessage,actualMessage);
    }


}
