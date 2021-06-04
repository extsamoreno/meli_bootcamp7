package meli.star.demo.service;

import meli.star.demo.dto.NombreRequestDTO;
import meli.star.demo.dto.NombreResponseDTO;

public interface BuscarNombre {

    NombreResponseDTO Obtenernombre(NombreRequestDTO nombreRequestDTO);
}
