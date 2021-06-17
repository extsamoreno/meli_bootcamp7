package com.desafiotesting.api.unit;

import com.desafiotesting.api.model.District;
import com.desafiotesting.api.repository.DistrictsRepository;
import com.desafiotesting.api.repository.IDistrictsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
@SpringBootTest
public class DistrictsRepositoryTest {
    IDistrictsRepository repository = new DistrictsRepository();

    @Test
    public void getDistrictsHappyPath(){
        //arrange
        District district1 = new District("Barrio Norte", 40.0);
        District district2 = new District("Centro", 100.0);
        District district3 = new District("Residencial", 80.0);

        Map<String, District> expected = new HashMap<>();
        expected.put("Barrio Norte", district1);
        expected.put("Centro", district2);
        expected.put("Residencial", district3);

        //act
        Map<String,District> received = repository.getDistricts();

        //assert
        Assertions.assertEquals(expected, received);
    }


}
