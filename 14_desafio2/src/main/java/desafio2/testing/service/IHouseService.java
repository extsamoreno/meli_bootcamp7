package desafio2.testing.service;

import desafio2.testing.exception.DisctictException;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.dto.*;

public interface IHouseService {
    void newHouse(HouseDTO houseDTO) throws NotFoundException, HouseExistException, HouseExistException, DisctictException;

    HouseMeterPropertyDTO meterProperty(int id) throws NotFoundException;

    HousePriceDTO priceProperty(int id) throws NotFoundException;

    HouseLargestEnvironmentDTO largestEnvironment(int id) throws NotFoundException;

    HouseMeterPerEnvironmentDTO meterPerEnvironment(int id) throws NotFoundException;
}
