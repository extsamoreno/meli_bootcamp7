package com.tucasitatasaciones.tucasitatasaciones.repositories;

import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;

public interface IOwnerRepository {
    int add(Ownership ownership);

    Ownership findFirst(int ownershipId);
}
