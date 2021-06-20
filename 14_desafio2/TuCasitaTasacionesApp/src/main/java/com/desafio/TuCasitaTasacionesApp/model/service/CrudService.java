package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyAlreadyExistException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService implements ICrudService{

    @Autowired
    IPropietyRepository iPropietyRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public String createPropiety(PropietyDTO propietyDTO) throws PropietyAlreadyExistException{
        Propiety propiety = mapToEntity(propietyDTO);

        if(!iPropietyRepository.create(propiety)) throw new PropietyAlreadyExistException(propiety.getName());

        return "La propiedad fue creada exitosamente";
    }


    private Propiety mapToEntity(PropietyDTO propietyDTO){
        Propiety propiety = mapper.map(propietyDTO, Propiety.class);
        return propiety;
    }
}