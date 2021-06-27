package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyAlreadyExistException;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import org.springframework.stereotype.Service;

@Service
public class CrudService implements ICrudService{


    IPropietyRepository iPropietyRepository;

    private PropertyMapper mapper;

    private Propiety propiety;

    public CrudService(IPropietyRepository iPropietyRepository, PropertyMapper modelMapper){
        this.iPropietyRepository = iPropietyRepository;
        this.mapper = modelMapper;
    }

    @Override
    public String createPropiety(PropietyDTO propietyDTO) throws PropietyAlreadyExistException{
        this.propiety = mapper.mapToModel(propietyDTO);

        boolean propiety1= iPropietyRepository.create(propiety);
        if(!propiety1) throw new PropietyAlreadyExistException(propiety.getName());

        return "La propiedad fue creada exitosamente";
    }

/*
    public Propiety mapToEntity(PropietyDTO propietyDTO){
        Propiety propiety = mapper.map(propietyDTO, Propiety.class);
        return propiety;
    }*/
}