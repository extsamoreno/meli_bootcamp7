package com.desafio.TuCasitaTasacionesApp.model.dao.repository;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Repository
public class PropietyRepository implements IPropietyRepository {

    /*********************************************/
    public static final Map<String, Double> m2PriceForNeighborhood =
        Collections.unmodifiableMap(new HashMap<String , Double>() {{
            put("Recoleta",    1000D);
            put("Chacarita", 800D);
            put("Flores",   600D);
            put("Constitucion",   500D);
    }});



    private HashMap<Integer, Propiety> propietyList = new HashMap<>();

    /*********************************************/


}