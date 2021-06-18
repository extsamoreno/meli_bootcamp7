package com.desafio2.testing.Service.Mapper;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;

import java.util.ArrayList;

public class PropiedadMapper {

    public static PropiedadM2DTO toPropiedadM2DTO(PropiedadModel propiedad, double m2){
       return new PropiedadM2DTO(propiedad.getProp_name(), m2);
    }


    public static PropiedadValorDTO toPropiedadValorDTO (PropiedadModel propiedad, double valor){
        return new PropiedadValorDTO(propiedad.getProp_name(), valor);
    }

    public static AmbienteDTO toAmbienteDTO (AmbienteModel ambiente, double m2){
        return new AmbienteDTO(ambiente.getEnviroment_name(), m2);
    }


    public static PropiedadListaAmbientesM2DTO toPropiedadListaAmbientesM2DTO(PropiedadModel propiedad, ArrayList<AmbienteDTO> ambientes){
        return new PropiedadListaAmbientesM2DTO(propiedad.getProp_name(),ambientes);
    }

    public static AmbienteModel toAmbienteModel (AmbienteRequestDTO ambiente){
      return new AmbienteModel(ambiente.getEnviroment_name(),ambiente.getEnviroment_width(), ambiente.getEnviroment_length());
    }

    public static PropiedadModel toPropiedadModel (PropiedadRequestDTO propiedad, BarrioModel barrio){
       ArrayList<AmbienteModel> ambientesM= new ArrayList<>();
       PropiedadModel propiedadModel= new PropiedadModel();

        for (AmbienteRequestDTO a: propiedad.getAmbientes()) {
            ambientesM.add(toAmbienteModel(a));
        }
        propiedadModel.setProp_name(propiedad.getProp_name());
        propiedadModel.setDistrict(barrio);
        propiedadModel.setAmbientes(ambientesM);
        propiedadModel.setCantAmbientes(ambientesM.size());

        return propiedadModel;
    }


}
