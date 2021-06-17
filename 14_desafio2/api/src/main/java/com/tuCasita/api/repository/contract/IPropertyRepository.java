package com.tuCasita.api.repository.contract;

import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;

import java.util.HashSet;

public interface IPropertyRepository {

    HashSet<String> getAllDistrictNames();
}
