package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilTest {

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


    public static PropiedadM2DTO createPropiedadM2DTO(){
       return new PropiedadM2DTO("Libertador 5",51.44);
    }


}
