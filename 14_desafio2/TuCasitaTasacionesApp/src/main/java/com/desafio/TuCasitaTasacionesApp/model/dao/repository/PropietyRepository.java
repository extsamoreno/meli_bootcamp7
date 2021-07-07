package com.desafio.TuCasitaTasacionesApp.model.dao.repository;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class PropietyRepository implements IPropietyRepository {

    /*********************************************/
    public static final Map<String, Double> m2PriceForNeighborhood =
        Collections.unmodifiableMap(new HashMap<>() {{
            put("Recoleta",    1000D);
            put("Chacarita", 800D);
            put("Flores",   600D);
            put("Constitucion",   500D);
    }});


    private List<Propiety> propietyList = new ArrayList<>();

    /*********************************************/

    @Override
    public Optional<Propiety> create(Propiety propiety) {
        Optional<Propiety> propietyOptional = Optional.empty();
        if(get(propiety.getName()).isEmpty()){
            propietyList.add(propiety);
            propietyOptional = Optional.of(propiety);
        }
        return propietyOptional;
    }

    @Override
    public Optional<Propiety> get(String name){
        Optional<Propiety> propietyOptional = Optional.empty();
        for (Propiety propietyAux : propietyList) {
            if (propietyAux.getName().equals(name)) propietyOptional = Optional.of(propietyAux);
        }
        return propietyOptional;
    }
}