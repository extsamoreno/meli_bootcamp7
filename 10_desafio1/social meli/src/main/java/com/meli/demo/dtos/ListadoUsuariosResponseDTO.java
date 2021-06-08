package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor@NoArgsConstructor
public class ListadoUsuariosResponseDTO {

    private int id;
    private String nombre;
    private ArrayList<UsuarioDTO> usuarios;
}
