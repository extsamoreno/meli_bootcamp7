package com.desafio2.Repository;

import com.desafio2.Model.District;

public interface IDistrctRepository {
    void save(District district);
    boolean delete(String distrct_name);
    boolean exists(District district);
    District findByName(String distrct_name);
}
