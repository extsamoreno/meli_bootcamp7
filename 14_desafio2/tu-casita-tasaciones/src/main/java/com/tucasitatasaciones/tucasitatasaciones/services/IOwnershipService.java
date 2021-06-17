package com.tucasitatasaciones.tucasitatasaciones.services;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithPriceDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithSquareMeterDTO;

public interface IOwnershipService {
    OwnershipWithDataDTO add(OwnershipWithDataDTO ownership) throws DistrictNotFoundException;

    OwnershipWithSquareMeterDTO calculateSquareMeterByOwnership(int ownershipId) throws OwnershipNotFoundException;

    OwnershipWithPriceDTO calculatePriceByOwnership(int ownershipId) throws DistrictNotFoundException, OwnershipNotFoundException;
}
