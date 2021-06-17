package desafio2.testing.repository;

import desafio2.testing.domian.House;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;

public interface IHouseRepository {
    House findUserById(int houseId) throws NotFoundException;
    void addHouse(House house) throws HouseExistException;
}
