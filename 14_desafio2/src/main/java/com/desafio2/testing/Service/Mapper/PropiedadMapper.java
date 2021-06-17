package com.desafio2.testing.Service.Mapper;

import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Dto.PropiedadValorDTO;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.AmbienteRepository;

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

}
