package desafio2.testing.repository;

import desafio2.testing.domian.House;
import desafio2.testing.exception.DisctictException;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.dto.HouseDTO;

public interface IHouseRepository {
    House findHouseById(int houseId) throws NotFoundException;
    void addHouse(HouseDTO houseDTO) throws HouseExistException, HouseExistException, DisctictException;
}
