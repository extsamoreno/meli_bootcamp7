package com.meli.desafio.repositories;

import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.utils.DataBase;
import com.meli.desafio.utils.Mappers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class CalculateRepository implements ICalculateRepository{
    private HashMap<Integer, House> listHouses = DataBase.listHouses;
    private HashMap<Integer, District> listDistrict = DataBase.listDistricts;

    @Override
    public Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException {
        for(House h: listHouses.values()){
            if(h.getName().equalsIgnoreCase(houseDTO.getName()))
                throw new HouseAlreadyExistsException(h.getName());
        }
        Integer districtId = listDistrict.values().stream()
                .filter(d -> d.getName().equalsIgnoreCase(houseDTO.getDistrict().getName()))
                .collect(Collectors.toList()).get(0).getId();

        House house = Mappers.houseDTOtoHouse(houseDTO, districtId);

        Integer id = listHouses.size() + 1;
        listHouses.put(id, house);
        return id;
    }

    @Override
    public House getById(Integer id) throws HouseNotFoundException {
        House house =  listHouses.get(id);
        if(house == null) throw new HouseNotFoundException(id);
        return house;
    }

    @Override
    public District getDistrict(Integer districtId) throws DistrictNotFoundException {
        District district = listDistrict.get(districtId);
        if(district == null) throw new DistrictNotFoundException(districtId);
        return district;
    }

    public Integer getSizeHouses(){
        return listHouses.size();
    }

    public void reset(){
        listHouses = DataBase.listHouses;

        listDistrict = DataBase.listDistricts;
    }
}
