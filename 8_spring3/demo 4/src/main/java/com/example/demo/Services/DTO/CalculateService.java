package com.example.demo.ServiceDTO;
import com.example.demo.Repository.Plato;
import com.example.demo.Services.DTO.ResponseDTO;

import java.util.List;

public interface CalculateService {
    public ResponseDTO calculate(Plato plato);
    public List<ResponseDTO> calculate(List<Plato> plato);
}