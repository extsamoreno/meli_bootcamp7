package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;
import com.desafio2.testing.Utils.IUtilDB;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UtilTest {

    @Autowired
    IUtilDB IUtilDB;

    public static PropertyModel createPropiedadModel(){

        //Propiedad Caballito, 4 ambientes, habitacion mas grande Cocina 17 m2, total: 51,44 m2
        RoomModel ba1= new RoomModel("Baño",4.8, 2.4);
        RoomModel d1= new RoomModel("Dormitorio1",3.9, 2.8);
        RoomModel d2= new RoomModel("Dormitorio2",5.0, 2.4);
        RoomModel cocina1= new RoomModel("Cocina",5.0, 3.4);

        PropertyModel propiedad = new PropertyModel(
                "Libertador 5",
                new DistrictModel("Caballito",3200.0),
                new ArrayList<RoomModel>(){{add(cocina1); add(ba1); add(d1);add(d2);}},
                4
        );
        return propiedad;
    }

    //Devuelve DTO con los m2 de la propiedad "Libertador 5"
    public static PropertyM2DTO createPropiedadM2DTO(){ return new PropertyM2DTO("Libertador 5",51.44); }

    //Devuelve DTO del ambiente mas grande de "Libertador 5"
    public static RoomDTO createAmbienteMayorDTO(){ return new RoomDTO("Cocina",17); }


    //Devuelve DTO lista de ambientes con sus m2 de "Libertador 5"
    public static PropertyRoomListM2DTO createPropiedadListaAmbientesM2DTO(){


        RoomDTO ba1= new RoomDTO("Baño",11.52);
        RoomDTO d1= new RoomDTO("Dormitorio1",10.92);
        RoomDTO d2= new RoomDTO("Dormitorio2",12.0);
        RoomDTO cocina1= new RoomDTO("Cocina",17.0);

       ArrayList<RoomDTO> roomDTOS = new ArrayList<RoomDTO>(){{add(cocina1); add(ba1); add(d1);add(d2);}};

       return new PropertyRoomListM2DTO("Libertador 5", roomDTOS);

    }

   public static PropiedadRequestDTO crearPropiedadRequestDTO() {
       PropiedadRequestDTO propiedadRequestDTO = new PropiedadRequestDTO();

       RoomRequestDTO ba1= new RoomRequestDTO("Baño",2.3,3.4);
       RoomRequestDTO d1= new RoomRequestDTO("Dormitorio1",5.92,2.4);
       RoomRequestDTO d2= new RoomRequestDTO("Dormitorio2",3.0,4.5);
       RoomRequestDTO cocina1= new RoomRequestDTO("Cocina",8.3,5.6);
       ArrayList<RoomRequestDTO> ambienteReqDTOS= new ArrayList<RoomRequestDTO>(){{add(cocina1); add(ba1); add(d1);add(d2);}};

       propiedadRequestDTO.setProp_name("Alvarez");
        propiedadRequestDTO.setDistrict_name("Almagro");
        propiedadRequestDTO.setDistrict_price(1200.3);
        propiedadRequestDTO.setRooms(ambienteReqDTOS);


       return propiedadRequestDTO;
    }

    public static PropertyValueDTO crearPropiedadValorDto(){
        return new PropertyValueDTO("Libertador 5",164608.00);
    }


}
