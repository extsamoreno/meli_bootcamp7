package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.DTO.PropertyDTO;

public interface IPropertyRepository {

    PropertyDTO findPropertyById(Integer id);
}
