package desafio2.testing.service;

import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.repository.IHouseRepository;
import desafio2.testing.service.dto.HouseLargestEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPerEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPropertyDTO;
import desafio2.testing.service.dto.HousePriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class HouseService implements IHouseService{

    @Autowired
    IHouseRepository houseRepository;

    @Override
    public void newHouse(House house) throws HouseExistException {
        houseRepository.addHouse(house);
    }

    @Override
    public HouseMeterPropertyDTO meterProperty(int id) throws NotFoundException {
        double result = calculateSquareMetersTotal(houseRepository.findUserById(id));
        return new HouseMeterPropertyDTO(houseRepository.findUserById(id).getProp_name(), result);

    }

    @Override
    public HousePriceDTO priceProperty(int id) throws NotFoundException {
        double result = calculateSquareMetersTotal(houseRepository.findUserById(id));
        return new HousePriceDTO(houseRepository.findUserById(id).getProp_name(), result * houseRepository.findUserById(id).getDistrict().getPrice());
    }

    @Override
    public HouseLargestEnvironmentDTO largestEnvironmente(int id) throws NotFoundException {
         EnvironmentHouse biggest = null;
        double maxRoom = 0.0;

        for (EnvironmentHouse environment : houseRepository.findUserById(id).getEnvironments()) {
            double squareFeet = environment.getLength()*environment.getWidth();
            if (biggest == null || squareFeet > maxRoom){
                biggest = environment;
                maxRoom = squareFeet;
            }
        }
        return new HouseLargestEnvironmentDTO(houseRepository.findUserById(id).getProp_name() , biggest , maxRoom);
    }

    @Override
    public HouseMeterPerEnvironmentDTO meterPerEnvironment(int id) throws NotFoundException {
        HouseMeterPerEnvironmentDTO house = new HouseMeterPerEnvironmentDTO();
        HashMap<String, Double> meterEnvironment = new HashMap<>();

        for(EnvironmentHouse e : houseRepository.findUserById(id).getEnvironments()){
            meterEnvironment.put(e.getName(), e.getLength()*e.getWidth());
        }

        house.setProp_name(houseRepository.findUserById(id).getProp_name());
        house.setMeterPerEnvironment(meterEnvironment);
        return house;
    }


    private double calculateSquareMetersTotal(House house){
        double result = 0.0;

        for (EnvironmentHouse h : house.getEnvironments()) {
            result += h.getLength() * h.getWidth();
        }
        return result;
    }

}
