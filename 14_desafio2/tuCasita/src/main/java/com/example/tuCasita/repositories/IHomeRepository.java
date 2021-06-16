package com.example.tuCasita.repositories;

import com.example.tuCasita.exceptions.AlreadyExistHomeException;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;

import java.util.List;

public interface IHomeRepository {
    Double getSquareMeterByHome(Integer homeId);
    Double getPrice(Integer homeId);
    Enviroment getBiggest(Integer homeId);
    List<Enviroment> findEnviromentsById(Integer homeId);
    Home getHomeById(Integer homeId);
    void insertHome(Home home) throws AlreadyExistHomeException;
}
