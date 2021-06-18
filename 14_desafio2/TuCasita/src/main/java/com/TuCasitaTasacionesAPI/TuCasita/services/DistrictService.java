package com.TuCasitaTasacionesAPI.TuCasita.services;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.DistrictDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.IDistrictRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService{

    @Autowired
    private IDistrictRepository iDistrictRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public int create(DistrictDTO district) throws DistrictAlreadyExistsException {

        if(iDistrictRepository.checkDistrictExists(mapper.map(district, District.class)))
            throw new DistrictAlreadyExistsException(district.getDistrict_name());

        return iDistrictRepository.create(mapper.map(district, District.class));
    }

    @Override
    public DistrictDTO getById(int id) throws DistrictNotFoundException {
        District district = iDistrictRepository.getById(id);

       if(district == null)
           throw new DistrictNotFoundException(id);

        return mapper.map(district, DistrictDTO.class);
    }


}
