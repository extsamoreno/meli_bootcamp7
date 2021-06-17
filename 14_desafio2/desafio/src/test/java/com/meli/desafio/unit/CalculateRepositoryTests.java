package com.meli.desafio.unit;


import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.CalculateRepository;
import com.meli.desafio.utils.DataBase;
import com.meli.desafio.utils.Mappers;
import com.meli.desafio.utils.TestUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculateRepositoryTests {

    private CalculateRepository calculateRepository = new CalculateRepository();
    private HouseDTO house = TestUtils.getTotalHouseDTO("House");
    private Integer houseId;

    @BeforeEach
    public void chargeDB() throws HouseAlreadyExistsException {
        DataBase db = new DataBase();
        db.loadDistricts();
        db.loadHouses();
        houseId = calculateRepository.save(house);
    }

    @AfterEach
    public void deleteHouse(){
        calculateRepository.reset();
    }

    @Test
    public void save() throws HouseAlreadyExistsException {
        HouseDTO house = TestUtils.getTotalHouseDTO("HouseTest");
        int initialSize = DataBase.listHouses.size();

        Integer id = calculateRepository.save(house);

        Assertions.assertTrue(initialSize < calculateRepository.getSizeHouses());
    }


    @Test
    public void getById() throws HouseNotFoundException {
        House expected = Mappers.houseDTOtoHouse(house, 1);

        House response = calculateRepository.getById(houseId);

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void getDistrict() throws DistrictNotFoundException {
        District expected = District.builder()
                .id(1)
                .name("Avellaneda")
                .price(2000.00)
                .build();

        District response = calculateRepository.getDistrict(1);

        Assertions.assertEquals(response, expected);
    }
}
