package calculadoraYStarWars.calculadoraYStarWars.controllers;

import calculadoraYStarWars.calculadoraYStarWars.dto.IngredienteResponseDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PlatoProcesadoResponseDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PlatoRequestDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PlatoResponseDTO;
import calculadoraYStarWars.calculadoraYStarWars.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraCaloriasController {
    @Autowired
    PlatoService platoService;

    @PostMapping("/caloriasTotales")
    public ResponseEntity<PlatoResponseDTO> caloriasTotales (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.caloriasTotalesPlato(plato), HttpStatus.OK);
    }

    @PostMapping("/caloriasCadaIngrediente")
    public ResponseEntity<ArrayList<IngredienteResponseDTO>> caloriasCadaIngrediente (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.caloriasCadaIngrediente(plato), HttpStatus.OK);
    }

    @PostMapping("/ingredienteConMasCalorias")
    public ResponseEntity<IngredienteResponseDTO> ingredienteConMasCalorias (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.ingredienteConMasCalorias(plato), HttpStatus.OK);
    }

    @PostMapping("/platosProcesados")
    public ResponseEntity<ArrayList<PlatoProcesadoResponseDTO>> platosProcesados (@RequestBody PlatoRequestDTO[] platos){
        return new ResponseEntity<>(platoService.platosProcesados(platos), HttpStatus.OK);
    }
}
