package meli.bootcamp.tucasita.controller;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.service.IPropertyService;
import meli.bootcamp.tucasita.service.dto.EnviromentResponseDTO;
import meli.bootcamp.tucasita.service.dto.EnviromentsMetersResponseDTO;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import meli.bootcamp.tucasita.service.dto.PropertyResponseDTO;
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
    @PostMapping("/meters")
    public ResponseEntity<PropertyResponseDTO> getMetersProperty(@Valid @RequestBody PropertyDTO property){
        return new ResponseEntity<>(iPropertyService.getMetersProperty(property), HttpStatus.OK);
    }

    /**
     * method to get property`s meters
     * @param nameProperty
     * @return PropertyMetersResponseDTO
     */
    @GetMapping("/meters/{name}")
    public ResponseEntity<PropertyResponseDTO> getMetersPropertyById(@PathVariable(name = "name",required = true) String nameProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getMetersProperty(nameProperty), HttpStatus.OK);
    }

    /**
     * method to get property`s price by name of the property
     * @param nameProperty
     * @return PropertyMetersResponseDTO
     * @throws PropertyNotFoundException
     */
    @GetMapping("/price/{name}")
    public ResponseEntity<PropertyResponseDTO> getPricePropertyById(@PathVariable(name = "name",required = true) String nameProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getPricePropertyById(nameProperty), HttpStatus.OK);
    }

    /**
     * method to get the largest environment of a property searched by id name
     * @param nameProperty
     * @return EnviromentResponseDTO
     * @throws PropertyNotFoundException
     */
    @GetMapping("/larger/{name}")
    public ResponseEntity<EnviromentResponseDTO> getLargerEnvironmentPropertyById(@PathVariable(name = "name",required = true) String nameProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getLargerEnvironmentPropertyById(nameProperty), HttpStatus.OK);
    }

    /**
     * method to get a list of environment with yours square meters
     * @param nameProperty
     * @return EnviromentsMetersResponseDTO
     * @throws PropertyNotFoundException
     */
    @GetMapping("/square-meters/{name}")
    public ResponseEntity<EnviromentsMetersResponseDTO> getMetersEnvironmentPropertyById(@PathVariable(name = "name",required = true) String nameProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getMetersEnvironmentPropertyById(nameProperty), HttpStatus.OK);
    }


}
