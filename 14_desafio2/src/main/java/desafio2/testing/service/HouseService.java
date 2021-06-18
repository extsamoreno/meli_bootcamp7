package desafio2.testing.service;

import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.exception.DistrictException;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.repository.IHouseRepository;
import desafio2.testing.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HouseService implements IHouseService{

    @Autowired
    IHouseRepository houseRepository;

    /**
     * Allows adding a house to the database
     * @param houseDTO
     * @throws HouseExistException
     * @throws DistrictException
     */
    @Override
    public void newHouse(HouseDTO houseDTO) throws HouseExistException, DistrictException {
        houseRepository.addHouse(houseDTO);
    }

    /**
     * It allows to determine the total square meters of a property, and returns the name of the property and the corresponding square meters
     * @param id
     * @return
     * @throws NotFoundException
     */
    @Override
    public HouseMeterPropertyDTO meterProperty(int id) throws NotFoundException {
        double result = calculateSquareMetersTotal(houseRepository.findHouseById(id));
        return new HouseMeterPropertyDTO(houseRepository.findHouseById(id).getProp_name(), result);

    }

    /**
     * It allows to determine the price of a property, returns the name of the property and the corresponding price.
     * @param id
     * @return
     * @throws NotFoundException
     */
    @Override
    public HousePriceDTO priceProperty(int id) throws NotFoundException {
        double result = calculateSquareMetersTotal(houseRepository.findHouseById(id));
        return new HousePriceDTO(houseRepository.findHouseById(id).getProp_name(), result * houseRepository.findHouseById(id).getDistrict().getPrice());
    }

    /**
     * It allows you to determine which is the largest environment of a property. Returns the name of the property,
     * the environment, and the corresponding meters.
     * @param id
     * @return
     * @throws NotFoundException
     */
    @Override
    public HouseLargestEnvironmentDTO largestEnvironment(int id) throws NotFoundException {
         EnvironmentHouse biggest = null;
        double maxRoom = 0.0;

        for (EnvironmentHouse environment : houseRepository.findHouseById(id).getEnvironments()) {
            double squareFeet = environment.getLength()*environment.getWidth();
            if (biggest == null || squareFeet > maxRoom){
                biggest = environment;
                maxRoom = squareFeet;
            }
        }
        return new HouseLargestEnvironmentDTO(houseRepository.findHouseById(id).getProp_name() , biggest , maxRoom);
    }

    /**
     * Allows you to determine meters by environment. Returns the name of the property and a hashMap
     * with the names of the environments and the corresponding meters
     * @param id
     * @return
     * @throws NotFoundException
     */
    @Override
    public HouseMeterPerEnvironmentDTO meterPerEnvironment(int id) throws NotFoundException {
        HouseMeterPerEnvironmentDTO house = new HouseMeterPerEnvironmentDTO();
        HashMap<String, Double> meterEnvironment = new HashMap<>();

        for(EnvironmentHouse e : houseRepository.findHouseById(id).getEnvironments()){
            meterEnvironment.put(e.getName(), e.getLength()*e.getWidth());
        }

        house.setProp_name(houseRepository.findHouseById(id).getProp_name());
        house.setMeterPerEnvironment(meterEnvironment);
        return house;
    }


    /**
     * Calculate the square meters of a house
     * @param house
     * @return
     */
    private double calculateSquareMetersTotal(House house){
        double result = 0.0;

        for (EnvironmentHouse h : house.getEnvironments()) {
            result += h.getLength() * h.getWidth();
        }
        return result;
    }

}
