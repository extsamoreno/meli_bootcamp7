package clase8.spring3.Ejercicio1.repository;

import clase8.spring3.Ejercicio1.service.dto.IngredienteDTO;

public interface IComidaRepository {
    IngredienteDTO findIngredienteByName(String nombre);
}
