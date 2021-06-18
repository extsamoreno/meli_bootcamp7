package com.meli.tu_casita.repository;

import com.meli.tu_casita.model.RealState;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IRealStateRepository {

    void save(RealState realState);

    boolean exists(RealState realState);

    RealState findById(int id);

    RealState findByName(String name);

    List<RealState> getRealStateList();

}
