package meli.star.demo.controller;

import meli.star.demo.dto.NombreRequestDTO;
import meli.star.demo.dto.NombreResponseDTO;
import meli.star.demo.service.BuscarNombre;
import meli.star.demo.service.BuscarNombreImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.EntityResponse;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/star")
public class WarsController {
    @Autowired
    BuscarNombre buscarNombre;


    @PostMapping("/match")
    public ResponseEntity<NombreResponseDTO> matchNombre(@RequestBody NombreRequestDTO nombre){
        return new ResponseEntity<NombreResponseDTO>(buscarNombre.Obtenernombre(nombre),HttpStatus.OK);
    }

}
