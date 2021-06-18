package desafio2.testing.unit;

import desafio2.testing.domian.House;
import desafio2.testing.exception.DistrictException;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.repository.HouseRepository;
import desafio2.testing.repository.IHouseRepository;
import desafio2.testing.service.dto.HouseDTO;
import desafio2.testing.util.Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;


public class RepositoryTest {

    IHouseRepository houseRepository = new HouseRepository();
    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void districtExistsByIdHappyPath() throws HouseExistException, DistrictException, NotFoundException {
        //arrange
        HouseDTO houseDisctric = Generator.houseHappy();

        //act
        houseRepository.addHouse(houseDisctric);

        //assert
        Assertions.assertEquals(houseRepository.findHouseById(houseDisctric.getId()), modelMapper.map(houseDisctric,House.class));
    }

    @Test
    public void districtNotExistsById() {
        //arrange
        HouseDTO houseDisctric = Generator.houseDistrictNotExist();

        //act and assert
        Assertions.assertThrows(DistrictException.class, () -> houseRepository.addHouse(houseDisctric));
    }

}
