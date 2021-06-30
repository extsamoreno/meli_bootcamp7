package com.appconsultorio.appconsultorio.controller;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.service.IOdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("odontologo")
@AllArgsConstructor
public class OdontologoController {

    IOdontologoService iOdontologoService;

    @PostMapping("/crearodontologo")
    public String crearOdontologo(@RequestBody Odontologo odontologo){
        iOdontologoService.crearOdontologo(odontologo);
        return "Odontologo creado correctamente";
    }

    @PostMapping("/editarodontologo")
    public String editarOdontologo(@RequestBody Odontologo odontologo){
        iOdontologoService.editarOdontologo(odontologo);
        return "Odontologo editado correctamente";
    }

    @PostMapping("/borrarodontologo")
    public String eliminarOdontologo(@RequestParam int id){
        iOdontologoService.eliminarOdontologo(id);
        return "Odontologo eliminado correctamente";
    }

    @GetMapping("/obtenerodontologos")
    public List<Odontologo> obtenerOdontologos(){
        return iOdontologoService.obtenerOdontologos();
    }
}
