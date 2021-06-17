package com.example.tuCasita.repositories;

import com.example.tuCasita.exceptions.AlreadyExistDistrictException;
import com.example.tuCasita.exceptions.AlreadyExistHomeException;
import com.example.tuCasita.exceptions.HomeIdNotFoundException;
import com.example.tuCasita.exceptions.HomeWithNoEnviromentsException;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;

import java.util.List;

public interface IHomeRepository {
    Double getSquareMeterByHome(Integer homeId) throws HomeIdNotFoundException;
    Double getPrice(Integer homeId) throws HomeIdNotFoundException;
    Enviroment getBiggest(Integer homeId) throws HomeIdNotFoundException, HomeWithNoEnviromentsException;
    List<Enviroment> findEnviromentsById(Integer homeId);
    Home getHomeById(Integer homeId);
    void insertHome(Home home) throws AlreadyExistHomeException;

    void insertDistrict(District district) throws AlreadyExistDistrictException;
    District findDistrictById(Integer id);
}
