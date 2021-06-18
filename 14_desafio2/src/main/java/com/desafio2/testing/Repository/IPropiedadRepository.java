package com.desafio2.testing.Repository;

import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;

import java.util.ArrayList;

public interface IPropiedadRepository {
  PropiedadModel getPropiedadByName(String name);


  boolean agregarPropiedad(String name, BarrioModel barrioModel, ArrayList<AmbienteModel> ambienteModels, int cant);
  boolean agregarPropiedad(PropiedadModel propiedad);

}
