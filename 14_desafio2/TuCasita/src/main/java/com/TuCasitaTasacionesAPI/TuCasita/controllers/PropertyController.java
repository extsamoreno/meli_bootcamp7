package com.TuCasitaTasacionesAPI.TuCasita.controllers;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.services.IPropertyService;
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

    /** Permite crear una propiedad
     *
     * @param propertyDTO
     * @return
     * @throws PropertyAlreadyExistsException
     * @throws DistrictNotFoundException
     */
    @PostMapping("/create")
    public ResponseEntity<Integer> create(@Valid @RequestBody PropertyDTO propertyDTO)
            throws PropertyAlreadyExistsException, DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.create(propertyDTO), HttpStatus.CREATED);
    }

    /** US0001
     *
     * @param idProperty
     * @return
     * @throws PropertyNotFoundException
     */
    @GetMapping("/m2/{idProperty}")
    public ResponseEntity<TotalM2DTO> calculateM2(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.calculateM2(idProperty), HttpStatus.OK);
    }

    /** US0002
     *
     * @param idProperty
     * @return
     * @throws PropertyNotFoundException
     * @throws DistrictNotFoundException
     */
    @GetMapping("/price/{idProperty}")
    public ResponseEntity<PricePropertyDTO> calculatePrice(@PathVariable int idProperty)
            throws PropertyNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.calculatePrice(idProperty), HttpStatus.OK);
    }

    /** US0003
     *
     * @param idProperty
     * @return
     * @throws PropertyNotFoundException
     */
    @GetMapping("/environment/biggest/{idProperty}")
    public ResponseEntity<EnvironmentBiggestDTO> environmentBiggest(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.environmentBiggest(idProperty), HttpStatus.OK);
    }

    /** US0004
     *
     * @param idProperty
     * @return
     * @throws PropertyNotFoundException
     */
    @GetMapping("/environments/m2/{idProperty}")
    public ResponseEntity<M2perEnvironmentsDTO> m2perEnvironments(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.m2perEnvironments(idProperty), HttpStatus.OK);
    }
}
