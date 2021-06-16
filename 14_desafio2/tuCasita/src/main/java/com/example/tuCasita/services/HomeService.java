package com.example.tuCasita.services;

import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.dtos.HomeResponseDTO;
import com.example.tuCasita.exceptions.AlreadyExistHomeException;
import com.example.tuCasita.exceptions.HomeIdNotFoundException;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;
import com.example.tuCasita.repositories.IHomeRepository;
import com.example.tuCasita.services.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService implements IHomeService{

    @Autowired
    private IHomeRepository homeRepository;

    @Override
    public Double getSquareMeterByHome(Integer homeId) {
        return homeRepository.getSquareMeterByHome(homeId);
    }

    @Override
    public HomeResponseDTO insertHome(HomeDTO homeDTO) throws AlreadyExistHomeException {
        homeRepository.insertHome(HomeMapper.homeDTOtoModel(homeDTO));

        Home home = homeRepository.getHomeById(homeDTO.getId());

        List<Enviroment> enviromentList = homeRepository.getHomeById(homeDTO.getId()).getEnviromentList();
        List<EnviromentDTO> enviromentDTOList = enviromentListToEnviromentDTOList(enviromentList);

        return new HomeResponseDTO(home.getId(),home.getName(),home.getDistrict(),enviromentDTOList);
    }

    @Override
    public Double getPrice(Integer homeId) {
        return homeRepository.getPrice(homeId);
    }

    @Override
    public EnviromentDTO getBiggest(Integer homeId) throws HomeIdNotFoundException {
        Enviroment enviroment = homeRepository.getBiggest(homeId);

        if (enviroment == null){
            throw new HomeIdNotFoundException(homeId);
        }

        Double meters = enviroment.getLength() * enviroment.getWidth();

        return new EnviromentDTO(enviroment.getName(),meters);
    }

    @Override
    public List<EnviromentDTO> getMeterCount(Integer homeId) throws HomeIdNotFoundException {
        List<Enviroment> enviromentDTOList = homeRepository.findEnviromentsById(homeId);
        List<EnviromentDTO> result = new ArrayList<>();

        if (enviromentDTOList == null){
            throw new HomeIdNotFoundException(homeId);
        }

        for (int i = 0; i < enviromentDTOList.size(); i++) {
            result.add(HomeMapper.toDTO(enviromentDTOList.get(i)));
        }

        return result;
    }

    private List<EnviromentDTO> enviromentListToEnviromentDTOList(List<Enviroment> enviromentList){
        List<EnviromentDTO> enviromentDTOList = new ArrayList<>();

        for (int i = 0; i < enviromentList.size(); i++) {
            enviromentDTOList.add(HomeMapper.toDTO(enviromentList.get(i)));
        }

        return enviromentDTOList;
    }
}
