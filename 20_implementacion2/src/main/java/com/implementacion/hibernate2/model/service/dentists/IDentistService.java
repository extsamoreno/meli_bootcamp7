package com.implementacion.hibernate2.model.service.dentists;

import com.implementacion.hibernate2.controller.dto.DentistDTO;

public interface IDentistService {

    DentistDTO getDentist(Long id);
}
