package com.example.desafio2.unit;

import com.example.desafio2.dtos.DistrictDTO;
import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.models.District;
import com.example.desafio2.models.Property;
import com.example.desafio2.services.mappers.DistrictMapper;
import com.example.desafio2.services.mappers.PropertyMapper;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictMapperTest {
    @Test
    public void toModelHappyPath() {
        District district = new District("district", 500);
        DistrictDTO districtDTO = new DistrictDTO("district", 500);

        Assertions.assertEquals(district, DistrictMapper.toModel(districtDTO));
    }
}
