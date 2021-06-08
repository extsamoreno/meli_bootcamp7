package com.example.demo.services;


import com.example.demo.dto.PlatoRequestDTO;
import com.example.demo.dto.PlatoResponseDTO;
import com.example.demo.repository.PlatoRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatoServiceImple implements PlatoService{
    @Autowired
    PlatoRepositoryImple platoRepositoryImple;

    @Override
    public PlatoResponseDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO){
        platoRepositoryImple.obtenerIngredientes();

        int suma = 0;
        double peso = 0;
        for (int i = 0; i < platoRequestDTO.getIngredientes().size(); i++) {
            peso = platoRequestDTO.getIngredientes().get(i).getPeso();
            suma= (int) (suma + (platoRepositoryImple.getIngredientes().get(platoRequestDTO.getIngredientes().get(i).getNombre()))*peso);
        }

        PlatoResponseDTO platoResponseDTO = new PlatoResponseDTO(platoRequestDTO.getNombre(), suma);
        return platoResponseDTO;
    }
}
