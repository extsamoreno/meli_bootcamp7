package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyAlreadyExistException;

public interface ICrudService {
    String createPropiety(PropietyDTO propietyDTO) throws PropietyAlreadyExistException;
}
