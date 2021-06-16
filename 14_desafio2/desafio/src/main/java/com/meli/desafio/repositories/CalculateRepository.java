package com.meli.desafio.repositories;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.utils.DataBase;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CalculateRepository implements ICalculateRepository{
    private HashMap<Integer, HouseDTO> listHouses = DataBase.listHouses;
    private HashMap<Integer, DistrictDTO> listDistrict = DataBase.listDistricts;

    @Override
    public Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException {
        for(HouseDTO h: listHouses.values()){
            if(h.getName().equalsIgnoreCase(houseDTO.getName()))
                throw new HouseAlreadyExistsException(h.getName());
        }

        Integer id = listHouses.size();
        listHouses.put(id, houseDTO);
        return id;
    }

    @Override
    public HouseDTO getById(Integer id) throws HouseNotFoundException {
        HouseDTO houseDTO =  listHouses.get(id);
        if(houseDTO == null) throw new HouseNotFoundException(id);
        return houseDTO;
    }
}
