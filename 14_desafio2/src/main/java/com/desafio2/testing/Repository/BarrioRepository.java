package com.desafio2.testing.Repository;


import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BarrioRepository implements IBarrioRepository {

    private static ArrayList<BarrioModel> barriosDataBase = new ArrayList<>();


    @Override
    public BarrioModel getBarrioByName(String name) {

        for (BarrioModel b : barriosDataBase) {
            if (b.getDistrict_name().equals(name)) {
                return b;
            }
        }
        return null;
    }

   /* public boolean agregarPropiedad(PropiedadModel propiedad){
        return propiedadesDataBase.add(propiedad);
    }*/






    public boolean agregarBarrio(BarrioModel barrioModel){

        //BarrioModel barrioModel =new BarrioModel(name,precio);

        return barriosDataBase.add(barrioModel);

    }






}
