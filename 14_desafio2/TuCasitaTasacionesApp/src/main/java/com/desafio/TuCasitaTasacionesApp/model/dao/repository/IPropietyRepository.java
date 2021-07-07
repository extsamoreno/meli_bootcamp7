package com.desafio.TuCasitaTasacionesApp.model.dao.repository;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;

import java.util.Optional;

public interface IPropietyRepository {

    Optional<Propiety> create(Propiety propiety);
    //boolean exist(Propiety propiety);
    Optional<Propiety> get(String name);
}
