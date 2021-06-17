package com.desafio2.testing.Service;

import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Dto.PropiedadValorDTO;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.AmbienteModel;

public interface IPropiedadService {

     PropiedadM2DTO calcularM2PropiedadDTO(String nombre) throws PropiedadInexistenteException;
     PropiedadValorDTO calcularValorPropiedadDTO(String nombre) throws PropiedadInexistenteException;
     AmbienteDTO calcularAmbienteMasGrande(String nombre) throws PropiedadInexistenteException;
     PropiedadListaAmbientesM2DTO calcularListaAmbientesM2(String nombre) throws PropiedadInexistenteException;

}
