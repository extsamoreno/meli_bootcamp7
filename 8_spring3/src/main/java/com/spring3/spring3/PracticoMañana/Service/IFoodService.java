package com.spring3.spring3.PracticoMañana.Service;

import com.spring3.spring3.PracticoMañana.DTO.FoodDTO;
import com.spring3.spring3.PracticoMañana.DTO.FoodResponseDTO;
import org.springframework.stereotype.Service;

public interface IFoodService {

    FoodResponseDTO responseFoodDTO(FoodDTO foodDTO);

}
