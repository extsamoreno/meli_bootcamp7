package desafio2.demo.repository;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository{
    List<DistrictDTO> districtList;

    public PropertyRepository() {
        this.districtList = new ArrayList<>(){{
            add(new DistrictDTO("Palermo",500));
            add(new DistrictDTO("La boca",450));
        }};
    }

    @Override
    public void validateDistrict(DistrictDTO district) throws DistrictNotFoundException {
        if (!this.districtList.contains(district)){
            throw new DistrictNotFoundException(district);
        }

    }

}
