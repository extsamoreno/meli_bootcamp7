package com.example.demo.CalculatingCalories.Services;
import com.example.demo.CalculatingCalories.Repository.Plato;
import com.example.demo.CalculatingCalories.Services.DTO.ResponseDTO;

import java.util.List;

public interface CalculateService {
    public ResponseDTO calculate(Plato plato);
    public List<ResponseDTO> calculate(List<Plato> plato);
}