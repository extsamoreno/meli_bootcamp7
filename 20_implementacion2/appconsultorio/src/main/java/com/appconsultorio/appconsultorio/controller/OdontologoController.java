package com.appconsultorio.appconsultorio.controller;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.service.IOdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("odontologo")
@AllArgsConstructor
public class OdontologoController {

    IOdontologoService iOdontologoService;

    @PostMapping("/crearodontologo")
    public String crearTurno(@RequestBody Odontologo odontologo){
        iOdontologoService.crearOdontologo(odontologo);
        return "Odontologo creado correctamente";
    }

    @PostMapping("/editarodontologo")
    public String editarTurno(@RequestBody Odontologo odontologo){
        iOdontologoService.editarOdontologo(odontologo);
        return "Odontologo editado correctamente";
    }

    @PostMapping("/borrarodontologo")
    public String borrarTurno(@RequestParam int id){
        iOdontologoService.eliminarOdontologo(id);
        return "Odontologo eliminado correctamente";
    }

    @GetMapping("/obtenerodontologos")
    public List<Odontologo> obtenerTurnos(){
        return iOdontologoService.obtenerOdontologos();
    }
}
