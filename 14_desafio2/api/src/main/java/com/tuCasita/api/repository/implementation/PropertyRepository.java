package com.tuCasita.api.repository.implementation;

import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import com.tuCasita.api.repository.contract.IPropertyRepository;
import com.tuCasita.api.repository.utils.DBGenerator;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class PropertyRepository implements IPropertyRepository {
    private final HashSet<String> districtNames = DBGenerator.loadDistricts();

    @Override
    public HashSet<String> getAllDistrictNames() {
        return districtNames;
    }

}
