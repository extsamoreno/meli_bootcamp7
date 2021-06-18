package com.desafio2.testing.Repository;

import com.desafio2.testing.Model.BarrioModel;

public interface IBarrioRepository {

    BarrioModel getBarrioByName(String name);
    boolean agregarBarrio(BarrioModel barrio);

}
