package com.spring3.ejercicios.starwars.service.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class NamesCharactersSWDTO {
    private ArrayList<String> listCharacters;

    public NamesCharactersSWDTO() {
        this.listCharacters = new ArrayList<>();
    }
}
