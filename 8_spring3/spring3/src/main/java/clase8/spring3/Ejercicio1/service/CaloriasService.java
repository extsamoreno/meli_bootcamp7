package clase8.spring3.Ejercicio1.service;

import clase8.spring3.Ejercicio1.dominio.Ingrediente;
import clase8.spring3.Ejercicio1.dominio.Plato;
import clase8.spring3.Ejercicio1.repository.IComidaRepository;
import clase8.spring3.Ejercicio1.service.dto.IngredienteDTO;
import clase8.spring3.Ejercicio1.service.dto.PlatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriasService implements  ICaloriasService{
    @Autowired
    IComidaRepository iComidaRepository;

    @Override
    public PlatoDTO getPlato(Plato plato) {
        List<IngredienteDTO> ingredientes = getListaingredientesByPeso(plato.getListaIngredientes());
        return new PlatoDTO(caloriasTotales(ingredientes) , ingredientes, ingredienteMaxCaloria(ingredientes));
    }

    private List<IngredienteDTO> getListaingredientesByPeso(List<Ingrediente> listaIngredientes) {
        return listaIngredientes.stream().map(
                    i -> new IngredienteDTO(i.getNombre(), getTotalCalorias(i))
                 ).collect(Collectors.toList());
    }

    private double getTotalCalorias(Ingrediente i){
       return i.getPeso()*(iComidaRepository.findIngredienteByName(i.getNombre()).getCalories());
    }

    private double caloriasTotales(List<IngredienteDTO> listIngredientes){
        return listIngredientes.stream().mapToDouble(
                i -> i.getCalories()
        ).sum();
    }

    private IngredienteDTO ingredienteMaxCaloria(List<IngredienteDTO> listIngredientes){
        return listIngredientes.stream().max(Comparator.comparing(IngredienteDTO::getCalories)).get();
    }


}
