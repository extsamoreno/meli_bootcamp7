package com.meli.tucasita.service;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.dto.PropertyWithM2DTO;

public interface IPropertyService {
    public PropertyWithM2DTO getTotalM2(String name) throws PropertyNotFoundException;
}
