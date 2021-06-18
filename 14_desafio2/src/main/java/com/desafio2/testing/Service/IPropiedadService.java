package com.desafio2.testing.Service;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.BarrioNoExistException;
import com.desafio2.testing.Exception.BarrioYaExistente;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Exception.PropiedadYaRegistradaException;
import com.desafio2.testing.Model.AmbienteModel;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;

public interface IPropiedadService {

     PropiedadM2DTO calcularM2PropiedadDTO(String nombre) throws PropiedadInexistenteException;
     PropiedadValorDTO calcularValorPropiedadDTO(String nombre) throws PropiedadInexistenteException;
     AmbienteDTO calcularAmbienteMasGrande(String nombre) throws PropiedadInexistenteException;
     PropiedadListaAmbientesM2DTO calcularListaAmbientesM2(String nombre) throws PropiedadInexistenteException;
     boolean crearPropiedad (PropiedadRequestDTO propiedadRequestDTO) throws BarrioNoExistException, PropiedadYaRegistradaException;
     BarrioModel crearBarrio(String nombreBarrio, double precio) throws BarrioYaExistente;
     BarrioModel obtenerBarrioPorNombre(String name);


}
