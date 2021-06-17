package com.desafio2.testing.Service;

import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Dto.PropiedadValorDTO;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.IBarrioRepository;
import com.desafio2.testing.Repository.IPropiedadRepository;
import com.desafio2.testing.Service.Mapper.PropiedadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropiedadService implements IPropiedadService {

    @Autowired
    IPropiedadRepository iPropiedadRepository;

    @Autowired
    IBarrioRepository iBarrioRepository;


    //Calcula los M2 de una propiedad por nombre y devuelve un DTO para mostrar
    //CU0001
   public PropiedadM2DTO calcularM2PropiedadDTO(String nombre) throws PropiedadInexistenteException {
        double m2=0;

        PropiedadModel propiedad = iPropiedadRepository.getPropiedadByName(nombre);
       if (propiedad == null) {
           throw new PropiedadInexistenteException(nombre);
       }
        m2= calcularM2Propiedad(propiedad);

        return PropiedadMapper.toPropiedadM2DTO(propiedad,m2);
    }


    private double calcularMetrosPorAmbiente (AmbienteModel ambiente){
       return ambiente.getEnviroment_length() *ambiente.getEnviroment_width();

    }

    //Calcula los M2 de una propiedad
    //CU0001 y CU0002
    private double calcularM2Propiedad(PropiedadModel propiedad){
        double m2=0;
        for (AmbienteModel a: propiedad.getAmbientes()) {
            m2+=calcularMetrosPorAmbiente(a);
        }
        return m2;
    }

    //CU0002
    public PropiedadValorDTO calcularValorPropiedadDTO(String nombre) throws PropiedadInexistenteException {
        double m2=0, valor=0;

        PropiedadModel propiedad = iPropiedadRepository.getPropiedadByName(nombre);
        m2= calcularM2Propiedad(propiedad);
        BarrioModel barrio= iBarrioRepository.getBarrioByName(propiedad.getDistrict().getDistrict_name());
        valor= barrio.getDistrict_price()*m2;

        return PropiedadMapper.toPropiedadValorDTO(propiedad,valor);

    }

    //CU0003
    //Calcula el ambiente mas grande de una propiedad por nombre y retorna un ambiente DTO
    public AmbienteDTO calcularAmbienteMasGrande(String nombre) throws PropiedadInexistenteException {
        PropiedadModel propiedad = iPropiedadRepository.getPropiedadByName(nombre);
        AmbienteModel ambienteMax= new AmbienteModel();
        double maxM2=0, m2=0;

        for (AmbienteModel a: propiedad.getAmbientes()) {
            m2=calcularMetrosPorAmbiente(a);
            if(m2>maxM2){
                maxM2=m2;
                ambienteMax= a;
            }
        }
        return PropiedadMapper.toAmbienteDTO(ambienteMax,maxM2);
    }

    //CU0004
    public PropiedadListaAmbientesM2DTO calcularListaAmbientesM2(String nombre) throws PropiedadInexistenteException {
        ArrayList<AmbienteDTO> ambientesDTOS= new ArrayList<>();
        double m2=0;

        PropiedadModel propiedad = iPropiedadRepository.getPropiedadByName(nombre);
        for (AmbienteModel a: propiedad.getAmbientes()) {
            m2=calcularMetrosPorAmbiente(a);
            ambientesDTOS.add(PropiedadMapper.toAmbienteDTO(a,m2));
        }
       return PropiedadMapper.toPropiedadListaAmbientesM2DTO(propiedad,ambientesDTOS);
    }





}
