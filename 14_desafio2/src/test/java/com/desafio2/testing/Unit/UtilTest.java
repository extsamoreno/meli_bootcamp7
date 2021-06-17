package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.IUtilDB;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UtilTest {

    @Autowired
    IUtilDB IUtilDB;

    public static PropiedadModel createPropiedadModel(){

        //Propiedad Caballito, 4 ambientes, habitacion mas grande Cocina 17 m2, total: 51,44 m2
        AmbienteModel ba1= new AmbienteModel("Baño",4.8, 2.4);
        AmbienteModel d1= new AmbienteModel("Dormitorio1",3.9, 2.8);
        AmbienteModel d2= new AmbienteModel("Dormitorio2",5.0, 2.4);
        AmbienteModel cocina1= new AmbienteModel("Cocina",5.0, 3.4);

        PropiedadModel propiedad = new PropiedadModel(
                "Libertador 5",
                new BarrioModel("Caballito",3200.0),
                new ArrayList<AmbienteModel>(){{add(cocina1); add(ba1); add(d1);add(d2);}},
                4
        );
        return propiedad;
    }

    //Devuelve DTO con los m2 de la propiedad "Libertador 5"
    public static PropiedadM2DTO createPropiedadM2DTO(){ return new PropiedadM2DTO("Libertador 5",51.44); }

    //Devuelve DTO del ambiente mas grande de "Libertador 5"
    public static AmbienteDTO createAmbienteMayorDTO(){ return new AmbienteDTO("Cocina",17); }


    //Devuelve DTO lista de ambientes con sus m2 de "Libertador 5"
    public static PropiedadListaAmbientesM2DTO createPropiedadListaAmbientesM2DTO(){


        AmbienteDTO ba1= new AmbienteDTO("Baño",11.52);
        AmbienteDTO d1= new AmbienteDTO("Dormitorio1",10.92);
        AmbienteDTO d2= new AmbienteDTO("Dormitorio2",12.0);
        AmbienteDTO cocina1= new AmbienteDTO("Cocina",17.0);

       ArrayList<AmbienteDTO> ambienteDTOS= new ArrayList<AmbienteDTO>(){{add(cocina1); add(ba1); add(d1);add(d2);}};

       return new PropiedadListaAmbientesM2DTO("Libertador 5",ambienteDTOS);

    }


}
