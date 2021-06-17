package meli.bootcamp.tucasita.repository;

import meli.bootcamp.tucasita.model.Distric;

public interface IDistrictRepository {
    Distric findById(String name);
}
