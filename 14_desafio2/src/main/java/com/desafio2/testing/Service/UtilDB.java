package com.desafio2.testing.Service;


import com.desafio2.testing.Exception.BarrioYaExistente;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class UtilDB implements IUtilDB {

    @Autowired
    IAmbienteRepository iAmbienteRepository;

    @Autowired
    IBarrioRepository iBarrioRepository;

    @Autowired
    IPropiedadRepository iPropiedadRepository;

    @Autowired
    IPropiedadService iPropiedadService;

    private  ArrayList<PropiedadRepository> propiedades;
    private  ArrayList<BarrioRepository> barrio;


     public void crearDataBase() throws BarrioYaExistente {
         BarrioModel b1= iPropiedadService.crearBarrio("Saavedra",3100.0);
         BarrioModel b2= iPropiedadService.crearBarrio("Belgrano",3000.0);
         BarrioModel b3= iPropiedadService.crearBarrio("Florida",2500.0);
         BarrioModel b4= iPropiedadService.crearBarrio("Nuñez",3200.0);
         System.out.println("Se crearon los barrios");


        AmbienteModel c1= new AmbienteModel("Comedor",5.0, 3.4);
        AmbienteModel c2= new AmbienteModel("Comedor",6.0, 2.1);
        AmbienteModel ba1= new AmbienteModel("Baño",4.8, 2.4);
        AmbienteModel ba2= new AmbienteModel("Baño",3.1, 5.4);
        AmbienteModel d1= new AmbienteModel("Dormitorio",3.9, 2.8);
        AmbienteModel d2= new AmbienteModel("Dormitorio",5.0, 2.4);
        AmbienteModel d3= new AmbienteModel("Dormitorio",8.2, 2.7);
        AmbienteModel l1= new AmbienteModel("Living",2.8, 3.4);
        AmbienteModel l2= new AmbienteModel("Living",4.5, 2.9);
        AmbienteModel l3= new AmbienteModel("Living",4.9, 5.4);
        AmbienteModel cocina1= new AmbienteModel("Cocina",5.0, 3.4);
        AmbienteModel cocina2= new AmbienteModel("Cocina",6.0, 2.1);

        System.out.println("Se crearon ambientes");

     ArrayList<AmbienteModel> ambientes3= new ArrayList<AmbienteModel>(){{add(c1); add(ba1); add(d1);}};
     ArrayList<AmbienteModel> ambientes2= new ArrayList<AmbienteModel>(){{add(ba2); add(cocina1);}};
     ArrayList<AmbienteModel> ambientes5= new ArrayList<AmbienteModel>(){{add(c1); add(d1); add(ba2);add(d1);add(d3);}};
     ArrayList<AmbienteModel> ambientes4= new ArrayList<AmbienteModel>(){{add(cocina2); add(ba1); add(d3);add(d2);}};



        iPropiedadRepository.agregarPropiedad("Moldes 100",b1,ambientes3,3);
        iPropiedadRepository.agregarPropiedad("Jaramillo 200",b1,ambientes2,2);
        iPropiedadRepository.agregarPropiedad("Amenabar 300",b1,ambientes5,5);
        iPropiedadRepository.agregarPropiedad("Cabildo 400",b1,ambientes4,4);

        System.out.println("Se crearon propiedades");


    }






}
