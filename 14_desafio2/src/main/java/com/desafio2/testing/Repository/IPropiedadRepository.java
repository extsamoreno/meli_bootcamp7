package com.desafio2.testing.Repository;

import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;

import java.util.ArrayList;

public interface IPropiedadRepository {
 public PropiedadModel getPropiedadByName(String name);
 //double getTotM2();   va en el service
 //AmbienteDAO getAmbienteMasGrande();   va en el service

  void altaPropiedad(String name, BarrioModel barrioModel, ArrayList<AmbienteModel> ambienteModels, int cant);


}
