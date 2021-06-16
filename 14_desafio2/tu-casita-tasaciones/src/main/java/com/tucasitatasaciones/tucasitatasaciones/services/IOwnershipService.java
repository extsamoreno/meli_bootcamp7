package com.tucasitatasaciones.tucasitatasaciones.services;

import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithPriceDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithSquareMeterDTO;

public interface IOwnershipService {
    OwnershipWithDataDTO add(OwnershipWithDataDTO ownership);

    OwnershipWithSquareMeterDTO calculateSquareMeterByOwnership(int ownershipId);

    OwnershipWithPriceDTO calculatePriceByOwnership(int ownershipId);
}
