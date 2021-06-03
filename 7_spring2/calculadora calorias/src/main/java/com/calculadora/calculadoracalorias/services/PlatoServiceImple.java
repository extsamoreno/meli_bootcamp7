package com.calculadora.calculadoracalorias.services;

import com.calculadora.calculadoracalorias.repository.PlatoRepository;
import com.calculadora.calculadoracalorias.repository.PlatoRepositoryImple;
import com.calculadora.calculadoracalorias.services.dto.PlatoDTO;
import com.calculadora.calculadoracalorias.services.dto.PlatoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatoServiceImple implements PlatoService{
    @Autowired
    PlatoRepositoryImple platoRepositoryImple;

    @Override
    public PlatoDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO){
        platoRepositoryImple.obtenerIngredientes();

        int suma = 0;
        for (int i = 0; i < platoRequestDTO.getIngredientes().size(); i++) {
            suma= suma + platoRepositoryImple.getIngredientes().get(platoRequestDTO.getIngredientes().get(i).getNombre());
        }

        PlatoDTO platoDTO = new PlatoDTO(platoRequestDTO.getNombre(), suma);
        return platoDTO;
    }
}
