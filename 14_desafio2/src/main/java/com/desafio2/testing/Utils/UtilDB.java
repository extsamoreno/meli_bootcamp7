package com.desafio2.testing.Utils;


import com.desafio2.testing.Exception.ExistentDistrictException;
import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Repository.*;
import com.desafio2.testing.Service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class UtilDB implements IUtilDB {

    @Autowired
    IRoomRepository iRoomRepository;

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IPropertyService iPropertyService;

    private  ArrayList<PropertyRepository> propiedades;
    private  ArrayList<DistrictRepository> barrio;


     public void crearDataBase() throws ExistentDistrictException {
         DistrictModel b1= iPropertyService.createNewDistrict("Saavedra",3100.0);
         DistrictModel b2= iPropertyService.createNewDistrict("Belgrano",3000.0);
         DistrictModel b3= iPropertyService.createNewDistrict("Florida",2500.0);
         DistrictModel b4= iPropertyService.createNewDistrict("Nuñez",3200.0);
         System.out.println("Se crearon los barrios");


        RoomModel c1= new RoomModel("Comedor",5.0, 3.4);
        RoomModel c2= new RoomModel("Comedor",6.0, 2.1);
        RoomModel ba1= new RoomModel("Baño",4.8, 2.4);
        RoomModel ba2= new RoomModel("Baño",3.1, 5.4);
        RoomModel d1= new RoomModel("Dormitorio",3.9, 2.8);
        RoomModel d2= new RoomModel("Dormitorio",5.0, 2.4);
        RoomModel d3= new RoomModel("Dormitorio",8.2, 2.7);
        RoomModel l1= new RoomModel("Living",2.8, 3.4);
        RoomModel l2= new RoomModel("Living",4.5, 2.9);
        RoomModel l3= new RoomModel("Living",4.9, 5.4);
        RoomModel cocina1= new RoomModel("Cocina",5.0, 3.4);
        RoomModel cocina2= new RoomModel("Cocina",6.0, 2.1);

        System.out.println("Se crearon ambientes");

     ArrayList<RoomModel> ambientes3= new ArrayList<RoomModel>(){{add(c1); add(ba1); add(d1);}};
     ArrayList<RoomModel> ambientes2= new ArrayList<RoomModel>(){{add(ba2); add(cocina1);}};
     ArrayList<RoomModel> ambientes5= new ArrayList<RoomModel>(){{add(c1); add(d1); add(ba2);add(d1);add(d3);}};
     ArrayList<RoomModel> ambientes4= new ArrayList<RoomModel>(){{add(cocina2); add(ba1); add(d3);add(d2);}};



        iPropertyRepository.addProperty("Moldes 100",b1,ambientes3,3);
        iPropertyRepository.addProperty("Jaramillo 200",b1,ambientes2,2);
        iPropertyRepository.addProperty("Amenabar 300",b1,ambientes5,5);
        iPropertyRepository.addProperty("Cabildo 400",b1,ambientes4,4);

        System.out.println("Se crearon propiedades");


    }






}
