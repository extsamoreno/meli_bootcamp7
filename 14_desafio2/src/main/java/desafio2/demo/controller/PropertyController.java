package desafio2.demo.controller;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.PropertyDTO;
import desafio2.demo.service.IPropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("property")
public class PropertyController {
    IPropertyService iPropertyService;

    public PropertyController(IPropertyService iPropertyService) {
        this.iPropertyService = iPropertyService;
    }

    @PostMapping("totalM2")
    public ResponseEntity<Double> getTotalM2(@Valid @RequestBody PropertyDTO propertyDTO) throws DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.getPropertyM2(propertyDTO), HttpStatus.OK);
    }
}
