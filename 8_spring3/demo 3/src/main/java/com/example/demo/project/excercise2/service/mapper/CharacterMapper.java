package com.example.demo.project.excercise2.service.mapper;

import com.example.demo.project.excercise1.repository.entities.Ingrediente;
import com.example.demo.project.excercise1.service.dto.IngredienteDTO;
import com.example.demo.project.excercise2.repository.entities.CharacterSW;
import com.example.demo.project.excercise2.repository.entities.CharacterSWListDTO;
import com.example.demo.project.excercise2.service.dto.NameOfCharacterListDTO;

import java.util.ArrayList;

public class CharacterMapper {
    public static NameOfCharacterListDTO toDTO(CharacterSWListDTO characterSWListDTO){
        ArrayList<String> names = new ArrayList<>();
        for(CharacterSW c: characterSWListDTO.getCharacterSWList()){
            names.add(c.getName());
        }
        return new NameOfCharacterListDTO(names);
    }
}
