package com.socialmeli.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter

public class PublicacionesVendedoresSeguidosDTO {

    private int userId;
    private ArrayList<PublicacionDTO> publicaciones;

}
