package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaVendedoresResponseDTO {
    private int userId;
    private String userName;
    private ArrayList<VendedorResponseDTO> followed;
}
