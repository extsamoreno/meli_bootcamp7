package com.meli.desafio2.Controller;

import com.meli.desafio2.DTOS.EnvironmentDTO;
import com.meli.desafio2.DTOS.PropertyDTO;
import com.meli.desafio2.DTOS.PropertyResponseTotalSquareMetersDTO;
import com.meli.desafio2.DTOS.PropertyResponseValueDTO;
import com.meli.desafio2.Service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PropertyController {
    @Autowired
    private IPropertyService iPropertyService;

    // US-0001: Calcular el total de metros cuadrados de una propiedad
    @PostMapping("/calculateTotalSquareMeters")
    public PropertyResponseTotalSquareMetersDTO calculateTotalSquareMeters(@Valid @RequestBody PropertyDTO property){
        return iPropertyService.calculateTotalSquareMeters(property);
    }

    // US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas.
    //Tener en cuenta que los precios por metro cuadrado están determinados según el
    //barrio.
    @PostMapping("/calculatePrice")
    public PropertyResponseValueDTO calculatePrice(@Valid @RequestBody PropertyDTO property){
        var load = iPropertyService.calculatePrice(property);
        return load;
    }

    // US-0003: Determinar cuál es el ambiente más grande.
    @PostMapping("/getBiggestEnvironment")
    public EnvironmentDTO getBiggestEnvironment(@Valid @RequestBody PropertyDTO property){
        return iPropertyService.getBiggestEnvironment(property);
    }
}
