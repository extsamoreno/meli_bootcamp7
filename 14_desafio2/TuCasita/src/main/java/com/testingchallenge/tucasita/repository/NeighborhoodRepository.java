package com.testingchallenge.tucasita.repository;

import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.model.Neighborhood;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NeighborhoodRepository implements iNeighborhoodRepository {

    public static Map<String, Neighborhood> neighborhoodMap = new HashMap<>();
    static {
        neighborhoodMap.put("Recoleta", new Neighborhood("Recoleta", (double) 1000));
        neighborhoodMap.put("Palermo", new Neighborhood("Palermo", (double) 750));
        neighborhoodMap.put("Almagro", new Neighborhood("Recoleta", (double) 600));
        neighborhoodMap.put("Chacarita", new Neighborhood("Recoleta", (double) 500));
        neighborhoodMap.put("Balvanera", new Neighborhood("Recoleta", (double) 300));
    }

    @Override
    public Neighborhood getByName (String name) throws NeighborhoodNotFoundException {
        Neighborhood neighborhood = neighborhoodMap.get(name);

        if (neighborhood == null) {
            throw new NeighborhoodNotFoundException(name);
        } else {
            return neighborhood;
        }
    }
}
