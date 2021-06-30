package com.example.demo.controller;

import com.example.demo.models.UsuarioModel;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/list/{name}")
    public ArrayList<UsuarioModel> obtenerUsuariosPorNombre(@PathVariable String name){
        return usuarioService.obtenerUsuariosPorNombre2(name);
    }


    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return this.usuarioService.guardarUsuario(usuarioModel);

    }


}
