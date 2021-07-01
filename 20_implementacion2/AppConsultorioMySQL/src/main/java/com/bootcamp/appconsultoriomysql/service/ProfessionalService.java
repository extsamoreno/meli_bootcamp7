package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.model.Professional;
import com.bootcamp.appconsultoriomysql.repository.IProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class ProfessionalService implements IProfessionalService{

    @Autowired
    private IProfessionalRepository professionalRepository;

    @Override
    public Set<Professional> findAllWithMoreThanTwoTurnsOnDay(LocalDateTime day) {
        return professionalRepository.findAllWithMoreThanTwoTurnsOnDay(day);
    }
}
