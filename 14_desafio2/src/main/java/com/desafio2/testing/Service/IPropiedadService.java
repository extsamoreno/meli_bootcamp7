package com.desafio2.testing.Service;

import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Dto.PropiedadValorDTO;
import com.desafio2.testing.Model.AmbienteModel;

public interface IPropiedadService {

     PropiedadM2DTO calcularM2PropiedadDTO(String nombre);
     PropiedadValorDTO calcularValorPropiedadDTO(String nombre);
     AmbienteDTO calcularAmbienteMasGrande(String nombre);
     PropiedadListaAmbientesM2DTO calcularListaAmbientesM2(String nombre);

}
