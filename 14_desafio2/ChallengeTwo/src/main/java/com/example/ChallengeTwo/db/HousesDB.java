package com.example.ChallengeTwo.db;

import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;

import java.util.ArrayList;
import java.util.HashMap;

public class HousesDB {



    //Initialize Districs
    public  final HashMap<String, District> databaseDistrics = new HashMap<>();
    District d1 = new District("Chapinero", 1300);
    District d2 = new District("Engativa", 900);
    District d3 = new District("Candelaria", 1500);
    District d4 = new District("Usaquen", 2300);
    District d5 = new District("Usme", 800);
    District d6 = new District("Soacha", 690);
    District d7 = new District("Suba", 1100);

    //Initialize Enviroments
    Environment e1 = new Environment("living-room",6.3,3.2);
    Environment e2 = new Environment("bedroom main",4.3,3.0);
    Environment e3 = new Environment("dinnerroom",2.5,2.2);
    Environment e4 = new Environment("bedroom 2 ",3.3,2.5);
    Environment e5 = new Environment("kitchen",3.9,1.8);
    Environment e6 = new Environment("bathroom",8.1,2.5);
    Environment e7 = new Environment("living-room",10.5,4.2);
    Environment e8 = new Environment("bedroom main",5.3,3.0);
    Environment e9 = new Environment("dinnerroom",4.5,2.0);
    Environment e10 = new Environment("bedroom 2 ",4.2,5.0);
    Environment e11= new Environment("kitchen",1.5,3.0);



    //Initialize houses
    public  final HashMap<String, House> dataBaseHouses = new HashMap<>();

    ArrayList<Environment> listEnvironmentsH1 = new ArrayList<>();
    ArrayList<Environment> listEnvironmentsH2 = new ArrayList<>();
    ArrayList<Environment> listEnvironmentsH3 = new ArrayList<>();
    ArrayList<Environment> listEnvironmentsH4 = new ArrayList<>();
    ArrayList<Environment> listEnvironmentsH5 = new ArrayList<>();



    //Add houses to database

    public HousesDB() {
        listEnvironmentsH1.add(e1);listEnvironmentsH1.add(e2);listEnvironmentsH1.add(e3); listEnvironmentsH1.add(e4);
        listEnvironmentsH2.add(e7);listEnvironmentsH2.add(e8);listEnvironmentsH2.add(e9);listEnvironmentsH2.add(e10);
        listEnvironmentsH3.add(e1); listEnvironmentsH3.add(e8);listEnvironmentsH3.add(e9); listEnvironmentsH3.add(e11);
        listEnvironmentsH4.add(e2); listEnvironmentsH4.add(e10);listEnvironmentsH3.add(e7); listEnvironmentsH3.add(e4);
        listEnvironmentsH5.add(e3); listEnvironmentsH5.add(e9);listEnvironmentsH5.add(e10); listEnvironmentsH5.add(e5);

        House h1 = new House("house1",d1,listEnvironmentsH1);
        House h2 = new House("house2",d2,listEnvironmentsH2);
        House h3 = new House("house3",d3,listEnvironmentsH3);
        House h4 = new House("house4",d4,listEnvironmentsH4);
        House h5 = new House("house5",d5,listEnvironmentsH5);
        House h6 = new House("house6",d6,listEnvironmentsH3);
        House h7 = new House("house7",d7,listEnvironmentsH2);
        House h8 = new House("house8",d4,listEnvironmentsH5);

        //Adding houses
        this.dataBaseHouses.put(h1.getHouseName(),h1);this.dataBaseHouses.put(h2.getHouseName(),h2);this.dataBaseHouses.put(h3.getHouseName(), h3);
        this.dataBaseHouses.put(h4.getHouseName(), h4);this.dataBaseHouses.put(h5.getHouseName(),h5);this.dataBaseHouses.put(h6.getHouseName(),h6);

        //Adding Ditrics
        this.databaseDistrics.put(d1.getDistricName(),d1);this.databaseDistrics.put(d2.getDistricName(),d2);this.databaseDistrics.put(d3.getDistricName(),d3);
        this.databaseDistrics.put(d4.getDistricName(),d4);this.databaseDistrics.put(d5.getDistricName(),d5);this.databaseDistrics.put(d6.getDistricName(),d6);
        this.databaseDistrics.put(d7.getDistricName(),d7);
    }

    public HashMap<String, House> getDataBaseHouses() {
        return dataBaseHouses;
    }
    public HashMap<String, District> getDataBaseDistrics() {
        return databaseDistrics;
    }
    public void  addHouse(House house){
        this.dataBaseHouses.put(house.getHouseName(),house);
    }
    public void addDistrict(District district) {this.databaseDistrics.put(district.getDistricName(),district);
    }
}
