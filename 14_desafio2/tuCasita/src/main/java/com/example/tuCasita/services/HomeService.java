package com.example.tuCasita.services;

import com.example.tuCasita.dtos.*;
import com.example.tuCasita.exceptions.*;
import com.example.tuCasita.models.District;
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
    public Double getSquareMeterByHome(Integer homeId) throws HomeIdNotFoundException {
        return homeRepository.getSquareMeterByHome(homeId);
    }

    @Override
    public HomeResponseDTO insertHome(HomeDTO homeDTO) throws AlreadyExistHomeException, DistrictNotFoundException, AlreadyExistEnviromentIdException {
        District district = homeRepository.findDistrictById(homeDTO.getDistrictId());

        if(district == null)
            throw new DistrictNotFoundException(homeDTO.getDistrictId());

        homeRepository.insertHome(HomeMapper.homeDTOtoModel(homeDTO, district));

        Home home = homeRepository.getHomeById(homeDTO.getId());

        List<Enviroment> enviromentList = homeRepository.getHomeById(homeDTO.getId()).getEnviromentList();
        List<EnviromentDTO> enviromentDTOList = enviromentListToEnviromentDTOList(enviromentList);

        return new HomeResponseDTO(home.getId(),home.getName(),home.getDistrict(),enviromentDTOList);
    }

    @Override
    public Double getPrice(Integer homeId) throws HomeIdNotFoundException {
        return homeRepository.getPrice(homeId);
    }

    @Override
    public EnviromentDTO getBiggest(Integer homeId) throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        Enviroment enviroment = homeRepository.getBiggest(homeId);

        if (enviroment == null){
            throw new HomeIdNotFoundException(homeId);
        }

        return new EnviromentDTO(enviroment.getId(), enviroment.getName(), enviroment.getWidth(), enviroment.getLength());
    }

    @Override
    public List<EnviromentAreasDTO> getMeterCount(Integer homeId) throws HomeIdNotFoundException {
        List<Enviroment> enviromentDTOList = homeRepository.findEnviromentsById(homeId);
        List<EnviromentAreasDTO> result = new ArrayList<>();

        if (enviromentDTOList == null){
            throw new HomeIdNotFoundException(homeId);
        }

        for (int i = 0; i < enviromentDTOList.size(); i++) {
            result.add(HomeMapper.toAreasDTO(enviromentDTOList.get(i)));
        }

        return result;
    }

    @Override
    public String insertDistrict(DistrictDTO districtDTO) throws AlreadyExistDistrictException {
        homeRepository.insertDistrict(HomeMapper.districtDTOToModel(districtDTO));
        return ("The district was added correctly");
    }

    @Override
    public District findDistrictById(Integer id) throws DistrictNotFoundException {
        return homeRepository.findDistrictById(id);
    }

    private List<EnviromentDTO> enviromentListToEnviromentDTOList(List<Enviroment> enviromentList){
        List<EnviromentDTO> enviromentDTOList = new ArrayList<>();

        for (int i = 0; i < enviromentList.size(); i++) {
            enviromentDTOList.add(HomeMapper.toDTO(enviromentList.get(i)));
        }

        return enviromentDTOList;
    }
}
