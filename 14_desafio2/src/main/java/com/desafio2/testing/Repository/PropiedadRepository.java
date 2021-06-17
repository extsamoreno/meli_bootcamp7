package com.desafio2.testing.Repository;

import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PropiedadRepository implements IPropiedadRepository{

    private static ArrayList<PropiedadModel> propiedadesDataBase = new ArrayList<>();




    public boolean agregarPropiedad(String name, BarrioModel barrioModel, ArrayList<AmbienteModel> ambienteModels, int cant){

        PropiedadModel propiedadModel =new PropiedadModel(name, barrioModel, ambienteModels, cant);
        propiedadesDataBase.add(propiedadModel);

        return true;
    }


    @Override
    public PropiedadModel getPropiedadByName(String name) {

        for (PropiedadModel p : propiedadesDataBase) {
            if (p.getProp_name().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
