package repository;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.model.District;
import com.meli.tucasita.repository.DistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryTest {

    @InjectMocks
    DistrictRepository districtRepository;

    @Test
    public void getAnExistentDistrict() throws DistrictNotFoundException {
        // Arrange
        String districtName="Fontibon";
        // Act
        District response= districtRepository.getDistrictByName(districtName);
        // Assert
        Assertions.assertEquals(new District("Fontibon",2000),response);
    }

    @Test
    public void getAnUnexistentDistrict() throws DistrictNotFoundException {
        // Arrange
        String districtName="Hola Mundo";
        // Act

        // Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> districtRepository.getDistrictByName(districtName));
    }
}
