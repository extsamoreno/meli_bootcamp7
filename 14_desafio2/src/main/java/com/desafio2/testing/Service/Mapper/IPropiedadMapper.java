package com.desafio2.testing.Service.Mapper;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;

import java.util.ArrayList;

public interface IPropiedadMapper {
      PropiedadM2DTO toPropiedadM2DTO(PropiedadModel propiedad, double m2);
      PropiedadValorDTO toPropiedadValorDTO (PropiedadModel propiedad, double valor);
      AmbienteDTO toAmbienteDTO (AmbienteModel ambiente, double m2);
      PropiedadListaAmbientesM2DTO toPropiedadListaAmbientesM2DTO(PropiedadModel propiedad, ArrayList<AmbienteDTO> ambientes);
      AmbienteModel toAmbienteModel (AmbienteRequestDTO ambiente);
      PropiedadModel toPropiedadModel (PropiedadRequestDTO propiedad, BarrioModel barrio);


}
