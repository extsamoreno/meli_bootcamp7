package meli.star.demo.service;

import meli.star.demo.dto.NombreRequestDTO;
import meli.star.demo.dto.NombreResponseDTO;
import meli.star.demo.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarNombreImple implements BuscarNombre {
    @Autowired
    StarWarsRepository starWarsRepository;

    @Override
    public NombreResponseDTO Obtenernombre(NombreRequestDTO nombreRequestDTO) {
        starWarsRepository.obtenerDatos();
        String regex=".*"+nombreRequestDTO.getNombre()+".*";


        List<String> listanombres = new ArrayList<>();
        for (int i = 0; i < starWarsRepository.getList().size() ; i++) {

            if(starWarsRepository.getList().get(i).toString().matches(regex)){

                listanombres.add(starWarsRepository.getList().get(i).toString());
            }
        }

        NombreResponseDTO listNombres= new NombreResponseDTO(listanombres);

        return listNombres;
    }
}
