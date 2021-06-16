package com.example.desafio2.repositories;

import com.example.desafio2.models.House;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HouseRepository implements IHouseRepository {
    HashMap<Integer,House> houseHm = new HashMap<>();

    @Override
    public void add(House house) {
        try{
            houseHm.put(houseHm.size()+1,house);
            listHouses();
        }catch (Exception e){
            //TODO: handle exception
        }
    }

    @Override
    public House getHouseById(int houseId) {
        return houseHm.get(houseId);
    }

    private void listHouses(){
        houseHm.forEach((a,b) -> {
            System.out.println(b.toString());
        });
    }
}
