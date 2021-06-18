package com.meli.tuCasita.reposioryTest;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.District;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.repository.HouseDAO;
import com.meli.tuCasita.repository.IHouseDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public class HouseRepositoryTest {

    IHouseDAO iHouseDAO = new HouseDAO();
    ModelMapper modelMapper = new ModelMapper();
    @Test
    public void HouseFindByIdHappyPath() throws HouseNotFoundException {
        //arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);



        //act
        House house1 = iHouseDAO.findById(houseID);

        //assert
        Assertions.assertEquals(house1.getHouseName(), house.getHouseName() );
    }
    @Test
    public void HouseSaveHappyPath() throws HouseNotFoundException {
        //arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);



        //act
        boolean houseDTO1 = iHouseDAO.save(house);

        //assert
        Assertions.assertTrue(houseDTO1);
    }
    @Test
    public void FindByDistrictHappyPath() throws HouseNotFoundException {
        //arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);



        //act
        House house1 = iHouseDAO.findByDistrict(district);

        //assert
        Assertions.assertEquals(house1.getHouseName(), house.getHouseName());
    }

}
