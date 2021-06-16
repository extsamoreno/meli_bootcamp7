package com.example.tuCasita.services;

import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.dtos.HomeResponseDTO;
import com.example.tuCasita.exceptions.AlreadyExistHomeException;
import com.example.tuCasita.exceptions.HomeIdNotFoundException;
import com.example.tuCasita.models.Home;

import java.util.List;

public interface IHomeService {
    Double getSquareMeterByHome(Integer homeId);
    HomeResponseDTO insertHome(HomeDTO homeDTO) throws AlreadyExistHomeException;
    Double getPrice(Integer homeId);
    EnviromentDTO getBiggest(Integer homeId) throws HomeIdNotFoundException;
    List<EnviromentDTO> getMeterCount(Integer homeId) throws HomeIdNotFoundException;
}
