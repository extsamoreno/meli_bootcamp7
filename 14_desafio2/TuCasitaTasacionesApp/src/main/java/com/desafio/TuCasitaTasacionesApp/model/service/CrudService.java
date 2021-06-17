package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService implements ICrudService{

    @Autowired
    IPropietyRepository iPropietyRepository;

    private ModelMapper mapper;

    public CrudService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String createPropiety(PropietyDTO propietyDTO){
        Propiety propiety = mapToEntity(propietyDTO);
/*
        if(!iPropietyRepository.verifyName(propiety)) throw new PropietyNameAlreadyExistException(propiety.getName())
        if(iPropietyRepository.
                iPropietyRepository.create();
*/
        return "";
    }

    private boolean verifyPropiety(PropietyDTO propietyDTO){
        boolean res =  false;
        return res;
    }
    private Propiety mapToEntity(PropietyDTO propietyDTO){
        Propiety propiety = mapper.map(propietyDTO, Propiety.class);
        return propiety;
    }
}
