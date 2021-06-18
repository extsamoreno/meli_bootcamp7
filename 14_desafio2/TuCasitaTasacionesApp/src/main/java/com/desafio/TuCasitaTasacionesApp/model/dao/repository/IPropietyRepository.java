package com.desafio.TuCasitaTasacionesApp.model.dao.repository;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;

public interface IPropietyRepository {

    boolean create(Propiety propiety);
    boolean exist(Propiety propiety);
    Propiety get(String name);
}
