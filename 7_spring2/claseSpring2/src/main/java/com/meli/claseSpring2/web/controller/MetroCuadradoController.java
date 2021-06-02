package com.meli.claseSpring2.web.controller;


import com.meli.claseSpring2.web.response.AreaDTO;
import com.meli.claseSpring2.web.response.AreasResponse;
import com.meli.claseSpring2.web.response.PrecioDTO;
import com.meli.claseSpring2.web.services.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.meli.claseSpring2.web.dto.CasaDTO;



import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/metrosCuadrados")
public class  MetroCuadradoController{

    ArrayList<CasaDTO> listaCasas = new ArrayList<>();


    @PostMapping("/save")
    public ResponseEntity<CasaDTO> save(@RequestBody CasaDTO casa){
        CasaService.guardarCasa(casa);
        return new ResponseEntity<>(casa, HttpStatus.CREATED);
    }

    @GetMapping("/area/{nombre}")
    public ResponseEntity<AreaDTO> calcularArea(@PathVariable("nombre") String pnombre){
        AreaDTO area = new AreaDTO();
        area.setArea(CasaService.calculoArea(pnombre));
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

    @GetMapping("/precio/{nombre}")
    public ResponseEntity<PrecioDTO> calcularPrecio(@PathVariable("nombre") String pnombre){
        PrecioDTO precio = new PrecioDTO();
        precio.setTamano(CasaService.calculoArea(pnombre));
        precio.setPrecio(precio.getTamano()*800);
        return new ResponseEntity<>(precio, HttpStatus.OK);
    }

    @GetMapping("/mayor/")
    public ResponseEntity<CasaDTO> calcularMayor(){
        return new ResponseEntity<>(CasaService.obtenerHabitacionGrande(), HttpStatus.OK);
    }

    @GetMapping("/habitaciones/{nombre}")
    public ResponseEntity<List<AreasResponse>> areaHabitaciones(@PathVariable("nombre") String pnombre){
        return new ResponseEntity<>(CasaService.obtenerHabitaciones(pnombre), HttpStatus.OK);
    }




}

