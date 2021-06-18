package com.meli.demo.service;


import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.response.EnvironmentSquareTotalDTO;
import com.meli.demo.dto.response.EnvironmentsTotalDTO;
import com.meli.demo.dto.response.PriceMetersResponseDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.model.House;
import com.meli.demo.repository.ITuCasitaRepository;
import com.meli.demo.service.mapper.HouseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TuCasitaService implements ITuCasitaService{


    //@Autowired
    //ModelMapper mapper;

    @Autowired
    ITuCasitaRepository iTuCasitaRepository;



    @Override
    public Boolean newCasita(HouseDTO houseDTO) throws HouseExistException, PriceIncorrectException, NeighborhoodNotFounException {
        boolean exist =iTuCasitaRepository.newCasita(HouseMapper.toHouse(houseDTO));
        //boolean exist =iTuCasitaRepository.newCasita(mapper.map(houseDTO, House.class));
        return exist;
    }

    @Override
    public TotalMetersResponseDTO totalMeters(String nameHouse) throws HouseNotFoundException {
        HouseDTO house = new HouseDTO();
        TotalMetersResponseDTO totalMetersResponseDTO = new TotalMetersResponseDTO();
        house=HouseMapper.toDTO(iTuCasitaRepository.getHouseByname(nameHouse));
        //house=mapper.map(iTuCasitaRepository.getHouseByname(nameHouse),HouseDTO.class);

        double suma=0;
        for (int i = 0; i <house.getEnvironments().size() ; i++) {
            suma=suma+(house.getEnvironments().get(i).getLeng()*house.getEnvironments().get(i).getWidth());
        }
        totalMetersResponseDTO.setNameHouse(house.getName());
        totalMetersResponseDTO.setTotalMeters(suma);

        return totalMetersResponseDTO;
    }

    @Override
    public PriceMetersResponseDTO priceMeters(String nameHouse) throws HouseNotFoundException {
        TotalMetersResponseDTO totalMetersResponseDTO= new TotalMetersResponseDTO();
        PriceMetersResponseDTO priceMetersResponseDTO = new PriceMetersResponseDTO();
        HouseDTO house = new HouseDTO();
        house=HouseMapper.toDTO(iTuCasitaRepository.getHouseByname(nameHouse));
        //house=mapper.map(iTuCasitaRepository.getHouseByname(nameHouse),HouseDTO.class);

        totalMetersResponseDTO= totalMeters(nameHouse);
        Double pricei = house.getNeighborhood().getPrice()*totalMetersResponseDTO.getTotalMeters();
        priceMetersResponseDTO.setNameHouse(house.getName());
        priceMetersResponseDTO.setPriceProp(pricei);
        return priceMetersResponseDTO;
    }

    @Override
    public EnvironmentDTO biggerEnvironment(String nameHouse) throws HouseNotFoundException {
        HouseDTO house = new HouseDTO();
        EnvironmentDTO environment = new EnvironmentDTO();
        house=HouseMapper.toDTO(iTuCasitaRepository.getHouseByname(nameHouse));
        //house=mapper.map(iTuCasitaRepository.getHouseByname(nameHouse),HouseDTO.class);
        double comparador=0;
        for (int i = 0; i <house.getEnvironments().size() ; i++) {
            if((house.getEnvironments().get(i).getLeng()*house.getEnvironments().get(i).getWidth()) >= comparador){
                comparador=(house.getEnvironments().get(i).getLeng()*house.getEnvironments().get(i).getWidth());
                environment=house.getEnvironments().get(i);
            }
        }
        return environment;

    }

    @Override
    public EnvironmentsTotalDTO  totalMetersByEnvironment(String nameHouse) throws HouseNotFoundException {
        HouseDTO house = new HouseDTO();

        EnvironmentsTotalDTO environmentsTotalDTO = new EnvironmentsTotalDTO();
        ArrayList<EnvironmentSquareTotalDTO> environmentSquareTotalDTOS = new ArrayList<>();

        house=HouseMapper.toDTO(iTuCasitaRepository.getHouseByname(nameHouse));
        //house=mapper.map(iTuCasitaRepository.getHouseByname(nameHouse),HouseDTO.class);
        environmentsTotalDTO.setNamneHouse(house.getName());
        for (int i = 0; i <house.getEnvironments().size() ; i++) {
            EnvironmentSquareTotalDTO environment = new EnvironmentSquareTotalDTO();
            environment.setTotalSquare((house.getEnvironments().get(i).getLeng()*house.getEnvironments().get(i).getWidth()));
            environment.setEnvironments(house.getEnvironments().get(i));
            environmentSquareTotalDTOS.add(environment);
        }

        environmentsTotalDTO.setEnvironments(environmentSquareTotalDTOS);
        return environmentsTotalDTO;
    }

    @Override
    public HouseDTO  viewHouse(String nameHouse) throws HouseNotFoundException {
        HouseDTO house;
        house=HouseMapper.toDTO(iTuCasitaRepository.getHouseByname(nameHouse));
        //house=mapper.map(iTuCasitaRepository.getHouseByname(nameHouse),HouseDTO.class);
        return house;
    }
    @Override
    public HashMap<String, Double> viewNeighborhoods(){
        return iTuCasitaRepository.viewNeighborhoods();
    }




}
