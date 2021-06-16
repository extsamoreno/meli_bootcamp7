package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.PropertyDTO;

import java.io.IOException;

public interface PropertyService {

    void saveProperty(PropertyDTO property) throws IOException;
}
