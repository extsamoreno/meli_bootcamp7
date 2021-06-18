package com.desafio.TuCasitaTasacionesApp.controllers;

import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseCost;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseTotalMeters;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomMetersListResponseDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/propiety")
public class CalculateRestController {

    @Autowired
    ICalculateService iCalculateService;

    @GetMapping("/calculate/squearemeter")
    public ResponseEntity<PropietyDTOResponseTotalMeters> getSquareMeterForPropiety(@RequestParam(name = "name")String name) throws PropietyNotFoundException {
        return new ResponseEntity<PropietyDTOResponseTotalMeters>(iCalculateService.getSquareMeterForPropiety(name), HttpStatus.OK);
    }

    @GetMapping("calculate/value")
    public ResponseEntity<PropietyDTOResponseCost> getValueForPropiety(@RequestParam(name = "name") String name) throws PropietyNotFoundException, NeighborhoodNotFoundException {
        return new ResponseEntity<>(iCalculateService.getValueForPropiety(name), HttpStatus.OK);
    }

    @GetMapping("room/obtainbiggest")
    public ResponseEntity<RoomDTO> getBiggestRoom(@RequestParam(name = "name") String name) throws PropietyNotFoundException {
        return new ResponseEntity<>(iCalculateService.getBiggestRoom(name), HttpStatus.OK);
    }

    @GetMapping("room/calculate/squearemeter")
    public ResponseEntity<RoomMetersListResponseDTO> getSquareMeterForRoom(@RequestParam(name = "name") String name) throws PropietyNotFoundException {
        return new ResponseEntity<>(iCalculateService.getSquareMeterForRoom(name), HttpStatus.OK);
    }

}
