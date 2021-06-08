package com.meli.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO {
    private int id;
    private String nombre;
    private ArrayList<PublicacionDTO> publicacions;
    private ArrayList<UsuarioDTO> usuarios;
}
