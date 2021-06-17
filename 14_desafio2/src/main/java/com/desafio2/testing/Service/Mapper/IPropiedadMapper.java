package com.desafio2.testing.Service.Mapper;

import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Model.PropiedadModel;

public interface IPropiedadMapper {
      PropiedadM2DTO toPropiedadM2DTO(PropiedadModel propiedad, double m2);
}
