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
    public int add(Ownership ownership) {
        int ownershipId = ownershipList.size() + 1;

        ownershipList.put(ownershipId, ownership);

        return ownershipId;
    }

    @Override
    public Ownership findFirst(int ownershipId) {
        return ownershipList.get(ownershipId);
    }
}
