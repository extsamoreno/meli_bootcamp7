package meli.bootcamp.tucasita.repository;

import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.service.dto.DistrictDTO;

public interface IDistrictRepository {

    District save(District district);
}
