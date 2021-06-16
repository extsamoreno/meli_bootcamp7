package com.example.desafio2.services;

import com.example.desafio2.dtos.ResponsePropertySquareDTO;

import java.io.FileNotFoundException;

public interface IPropertyService {

    ResponsePropertySquareDTO getSquareMeters(int id) throws FileNotFoundException;
}
