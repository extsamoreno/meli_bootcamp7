package com.meli.tu_casita.repository;

import com.meli.tu_casita.model.Environment;

import java.util.List;

public interface IEnvironmentDAO {
    void save(Environment stu);

    boolean exists(int id);

    Environment findById(int id);

    List<Environment> getEnvironmentsListByRealStateId(int realStateId);
}
