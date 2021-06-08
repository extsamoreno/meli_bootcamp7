package com.example.exercise.services;
import com.example.exercise.repositories.Plato;
import com.example.exercise.services.dto.ResponseDTO;

import java.util.List;

public interface CalculateService {
    public ResponseDTO calculate(Plato plato);
    public List<ResponseDTO> calculate(List<Plato> plato);
}
