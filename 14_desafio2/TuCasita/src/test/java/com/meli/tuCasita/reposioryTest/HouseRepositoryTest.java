package com.meli.tuCasita.reposioryTest;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;
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
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);



        //act
        HouseDTO houseDTO1 = iHouseDAO.findById(houseID);

        //assert
        Assertions.assertEquals(houseDTO1.getHouseName(),houseDTO.getHouseName() );
    }
    @Test
    public void HouseSaveHappyPath() throws HouseNotFoundException {
        //arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);



        //act
        boolean houseDTO1 = iHouseDAO.save(houseDTO);

        //assert
        Assertions.assertTrue(houseDTO1);
    }
    @Test
    public void FindByDistrictHappyPath() throws HouseNotFoundException {
        //arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);



        //act
        HouseDTO houseDTO1 = iHouseDAO.findByDistrict(districtDTO);

        //assert
        Assertions.assertEquals(houseDTO1.getHouseName(),houseDTO.getHouseName());
    }

}
