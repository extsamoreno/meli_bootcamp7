package desafio2.testing.service;

import desafio2.testing.domian.House;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.dto.HouseLargestEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPerEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPropertyDTO;
import desafio2.testing.service.dto.HousePriceDTO;

public interface IHouseService {
    void newHouse(House house) throws NotFoundException, HouseExistException;

    HouseMeterPropertyDTO meterProperty(int id) throws NotFoundException;

    HousePriceDTO priceProperty(int id) throws NotFoundException;

    HouseLargestEnvironmentDTO largestEnvironmente(int id) throws NotFoundException;

    HouseMeterPerEnvironmentDTO meterPerEnvironment(int id) throws NotFoundException;
}
