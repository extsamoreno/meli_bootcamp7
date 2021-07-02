package com.implementacion.hibernate2.model.service.dentists;

import com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsListDTO;
import com.implementacion.hibernate2.controller.dto.dentists.DentistDTO;

public interface IDentistService {

    DentistDTO getDentist(Long id);

    DentistAndTurnsListDTO listDentistByDateAndTurns(String date, int turns);
}
