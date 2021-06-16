package com.example.desafio2.services;

import com.example.desafio2.dtos.ResponsePropertySquareDTO;

public interface IPropertyService {

    ResponsePropertySquareDTO getSquareMeters(String houseName);
}
