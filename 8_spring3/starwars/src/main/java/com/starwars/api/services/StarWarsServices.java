package com.starwars.api.services;

import com.starwars.api.dto.CaracterResponseDTO;
import com.starwars.api.dto.NameRequestDTO;
import com.starwars.api.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServices {

    @Autowired
    StarWarsRepository starWarsRepository;

    public List<CaracterResponseDTO> search(NameRequestDTO nameRequestDTO){
        List<CaracterResponseDTO> caractersResponseDTO = new ArrayList<>();
        List<CaracterResponseDTO> starWarsCaracters = starWarsRepository.loadData();

        String nameBody = nameRequestDTO.getName();
        String nameBD;

        for (int i = 0; i < starWarsCaracters.size(); i++) {

            nameBD = starWarsCaracters.get(i).getName();
            int valid = StringUtils.countOccurrencesOf(nameBD, nameBody);

            if (valid == 1){
                caractersResponseDTO.add(starWarsCaracters.get(i));
            }
        }
        return caractersResponseDTO;
    }
}
