package com.meli.API_star_wars.service;

import com.meli.API_star_wars.service.dto.CharacterResDTO;

import java.util.ArrayList;

public interface Service {

    ArrayList<CharacterResDTO> returnCharaterResDTO(String name);

}
