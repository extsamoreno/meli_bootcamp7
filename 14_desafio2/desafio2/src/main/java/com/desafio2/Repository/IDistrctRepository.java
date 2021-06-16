package com.desafio2.Repository;

import com.desafio2.Model.District;

public interface IDistrctRepository {
    boolean exists(District district);
    District findByName(String name);
}
