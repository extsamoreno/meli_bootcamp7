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
    public boolean create(Propiety propiety){
        boolean res = true;
        if(!exist(propiety)) propietyList.add(propiety);
        else res = false;
        return res;
    }

    @Override
    public boolean exist(Propiety propiety){
        boolean res = false;
        for (Propiety propietyAux : propietyList) {
            if (propiety.equals(propietyAux)) res = true;
        }
        return res;
    }

    @Override
    public Propiety get(String name){
        System.out.println("Estoy en repository");
        Propiety propiety = null;
        for (Propiety propietyAux : propietyList) {
            if (propietyAux.getName().equals(name)) propiety = propietyAux;
        }
        return propiety;
    }
}