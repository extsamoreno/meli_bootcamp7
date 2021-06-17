package desafio2.demo.unit;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;
import desafio2.demo.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyRepositoryTest {
    @InjectMocks
    PropertyRepository propertyRepository;

    @Test
    void validateDistrictInvalid(){
        //arrange
        var district = new DistrictDTO("d1",499);
        //act
        //assert
        assertThrows(DistrictNotFoundException.class,()->propertyRepository.validateDistrict(district));
    }

    @Test
    void validateDistrictValid() throws DistrictNotFoundException {
        //arrange
        var district = new DistrictDTO("Palermo",500);
        //act
        propertyRepository.validateDistrict(district);

    }
}