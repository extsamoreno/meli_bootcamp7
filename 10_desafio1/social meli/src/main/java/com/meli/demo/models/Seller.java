package com.meli.demo.models;

import com.meli.demo.dtos.PostDTO;
import com.meli.demo.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor@NoArgsConstructor
public class Seller {

    private int id;
    private String nombre;
    private ArrayList<PostDTO> publicacions;
    private ArrayList<UserDTO> usuarios;
}
