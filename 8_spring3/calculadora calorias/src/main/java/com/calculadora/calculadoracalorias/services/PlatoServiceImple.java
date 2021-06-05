package com.calculadora.calculadoracalorias.services;

import com.calculadora.calculadoracalorias.dto.IngredienteResponseDTO;
import com.calculadora.calculadoracalorias.repository.PlatoRepositoryImple;
import com.calculadora.calculadoracalorias.dto.PlatoResponseDTO;
import com.calculadora.calculadoracalorias.dto.PlatoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


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

    @Override
    public ArrayList<IngredienteResponseDTO> caloriasCadaIngrediente(PlatoRequestDTO platoRequestDTO){
        platoRepositoryImple.obtenerIngredientes();
        ArrayList<IngredienteResponseDTO> ingredienteResponseDTOS = new ArrayList<>();

        for (int i = 0; i < platoRequestDTO.getIngredientes().size(); i++) {
            String nombre = platoRequestDTO.getIngredientes().get(i).getNombre();
            int calorias = platoRepositoryImple.getIngredientes().get(platoRequestDTO.getIngredientes().get(i).getNombre());

            IngredienteResponseDTO ingredienteResponseDTO = new IngredienteResponseDTO(nombre, calorias);
            ingredienteResponseDTOS.add(ingredienteResponseDTO);
        }
        return ingredienteResponseDTOS;
    }
    @Override
    public IngredienteResponseDTO ingredienteConMasCalorias(PlatoRequestDTO platoRequestDTO){
        platoRepositoryImple.obtenerIngredientes();
        IngredienteResponseDTO ingredienteResponseDTO = new IngredienteResponseDTO();

        int calorias = 0;
        int caloriasMax=0;

        for (int i = 0; i < platoRequestDTO.getIngredientes().size(); i++) {
            calorias = platoRepositoryImple.getIngredientes().get(platoRequestDTO.getIngredientes().get(i).getNombre());
            if (calorias>caloriasMax){
                caloriasMax=calorias;
                String nombre = platoRequestDTO.getIngredientes().get(i).getNombre();
                ingredienteResponseDTO.setNombre(nombre);
                ingredienteResponseDTO.setCalorias(calorias);
            }
        }
        return ingredienteResponseDTO;
    }



}
