package com.example.CalculadoraMetrosCuadrados.controller;

import com.example.CalculadoraMetrosCuadrados.dto.*;
import com.example.CalculadoraMetrosCuadrados.service.CalculateServiceImpl;
import com.example.CalculadoraMetrosCuadrados.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CalculateRestController {

  @Autowired
  @Qualifier("CalculateService")
  private ICalculateService calculateService;

  /** US-0001: Calcular el total de metros cuadrados de una propiedad */

  @PostMapping("/calculateTotalSquareFeet")
  public HouseResponseTotalSquareFeetDTO calculateTotalSquareFeet(@Valid @RequestBody HouseDTO house){
    return calculateService.calculateTotalSquareFeet(house);
  }

  /**   US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas.*/

  @PostMapping("/calculatePrice")
  public HouseResponseValueDTO calculatePrice(@Valid @RequestBody HouseDTO house){
    var ret = calculateService.calculatePrice(house);
    return ret;
  }

  /**   US-0003: Determinar cuál es el ambiente más grande. */

  @PostMapping("/getBiggestRoom")
  public RoomDTO getBiggestRoom(@Valid @RequestBody HouseDTO house){
    return calculateService.getBiggestRoom(house);
  }

  /**    US-0004: Determinar la cantidad de m2 que tiene cada ambiente de una propiedad. */

  @PostMapping("/calculateSquareFeetPerRoom")
  public HouseResponseSquareFeetPerRoomDTO calculateSquareFeetPerRoom(@Valid @RequestBody HouseDTO house){
    return calculateService.calculateSquareFeetPerRoom(house);
  }

}
