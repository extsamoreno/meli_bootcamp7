package com.tuCasita.api.service.contract;

import com.tuCasita.api.dto.*;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;

public interface IPropertyService {
    PropertyWithTotalSquareMetersDTO getTotalSquareMeters(PropertyDTO dto) throws DistrictNameNotFoundException;

    PropertyWithTotalValueDTO getTotalValue(PropertyDTO dto) throws DistrictNameNotFoundException;

    PropertyWithBiggestEnvironmentDTO calculateBiggestEnvironment(PropertyDTO dto) throws DistrictNameNotFoundException;

    PropertyWithTotalSquareMetersByEnvironmentDTO getTotalSquareMetersByEnvironment(PropertyDTO dto) throws DistrictNameNotFoundException;
}
