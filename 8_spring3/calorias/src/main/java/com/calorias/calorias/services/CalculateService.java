package com.calorias.calorias.services;
import com.calorias.calorias.repositories.Plato;
import com.calorias.calorias.services.dto.ResponseDTO;

import java.util.List;

public interface CalculateService {
    public ResponseDTO calculate(Plato plato);
    public List<ResponseDTO> calculate(List<Plato> plato);
}
