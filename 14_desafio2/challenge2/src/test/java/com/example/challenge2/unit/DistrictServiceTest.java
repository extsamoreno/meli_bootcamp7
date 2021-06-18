package com.example.challenge2.unit;

import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.repositories.IDistrictDAO;
import com.example.challenge2.serivces.DistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {
    @Mock
    IDistrictDAO districtDAO;

    @Test
    public void createDistrictCorrectly(){
        //Arrange
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        Mockito.when(districtDAO.save(district)).thenReturn(district);

        //Act
        District res = districtDAO.save(district);

        //Assert
        Assertions.assertEquals(district,res);
    }


}
