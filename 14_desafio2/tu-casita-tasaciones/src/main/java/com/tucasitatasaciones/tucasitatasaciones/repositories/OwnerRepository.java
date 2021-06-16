package com.tucasitatasaciones.tucasitatasaciones.repositories;

import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.District;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OwnerRepository implements IOwnerRepository {

    private HashMap<Integer, Ownership> ownershipList;

    public OwnerRepository() {
        this.ownershipList = new HashMap<>();
    }

    @Override
    public Ownership add(Ownership ownership) {
        ownershipList.put(ownershipList.size() + 1, ownership);
        return null;
    }

    @Override
    public Ownership findFirst(int ownershipId) {
        return ownershipList.get(ownershipId);
    }
}
