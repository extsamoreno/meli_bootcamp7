package com.starwars.api.controller;

import com.starwars.api.dto.CaracterResponseDTO;
import com.starwars.api.dto.NameRequestDTO;
import com.starwars.api.services.StarWarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {
    @Autowired
    StarWarsServices starWarsServices;

    @PostMapping("/search")
    public List<CaracterResponseDTO> search(@RequestBody NameRequestDTO nameRequestDTO){
        return starWarsServices.search(nameRequestDTO);
    }

}
