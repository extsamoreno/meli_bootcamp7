package com.spring3.ejercicios.food.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class MultipleFoodServiceImpl implements IMultipleFoodService{

    @Autowired
    IFoodService iFoodService2;

    @Override
    public List<FoodResponseDTO> multipleResponseFoodDTO(List<FoodDTO> listFoodDTO) {

        List<FoodResponseDTO> listFoodResponseDTO = new ArrayList<>();
        for (FoodDTO footDTO : listFoodDTO) {
            listFoodResponseDTO.add(iFoodService2.responseFoodDTO(footDTO));
        }

        return listFoodResponseDTO;
    }
}
