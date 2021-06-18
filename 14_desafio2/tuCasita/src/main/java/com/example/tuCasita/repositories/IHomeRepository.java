package com.example.tuCasita.repositories;

import com.example.tuCasita.exceptions.*;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;

import java.util.List;

public interface IHomeRepository {
    List<Enviroment> findEnviromentsById(Integer homeId);
    Home getHomeById(Integer homeId);
    void insertHome(Home home) throws AlreadyExistHomeException, AlreadyExistEnviromentIdException;

    void insertDistrict(District district) throws AlreadyExistDistrictException;
    District findDistrictById(Integer id) throws DistrictNotFoundException;
}
