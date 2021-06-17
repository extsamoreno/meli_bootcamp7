package meli.bootcamp.tucasita.controller;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.service.IPropertyService;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import meli.bootcamp.tucasita.service.dto.PropertyMetersResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {


    @Autowired
    IPropertyService iPropertyService;

    /**
     * method to save a property and return property and property`s meters
     * @param property
     * @return PropertyMetersResponseDTO
     */
    @GetMapping("/meters")
    public ResponseEntity<PropertyMetersResponseDTO> getMetersProperty(@Valid @RequestBody PropertyDTO property){
        return new ResponseEntity<>(iPropertyService.getMetersProperty(property), HttpStatus.OK);
    }

    /**
     * method to get property`s meters
     * @param nameProperty
     * @return PropertyMetersResponseDTO
     */
    @GetMapping("/meters/{name}")
    public ResponseEntity<PropertyMetersResponseDTO> getMetersPropertyById(@PathVariable(name = "name",required = true) String nameProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getMetersProperty(nameProperty), HttpStatus.OK);
    }
}
