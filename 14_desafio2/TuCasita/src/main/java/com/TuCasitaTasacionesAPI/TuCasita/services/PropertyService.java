package com.TuCasitaTasacionesAPI.TuCasita.services;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.models.Environment;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IDistrictService iDistrictService;

    @Autowired
    ModelMapper mapper;

    @Override
    public int create(PropertyDTO propertyDTO) throws PropertyAlreadyExistsException, DistrictNotFoundException {
        DistrictDTO district = iDistrictService.getById(propertyDTO.getDistrict_id());

        if(district == null)
            throw new DistrictNotFoundException(propertyDTO.getDistrict_id());

        if(iPropertyRepository.checkPropertyExists(mapper.map(propertyDTO, Property.class)))
            throw new PropertyAlreadyExistsException(propertyDTO.getProp_name(), district.getDistrict_name());

        int id = iPropertyRepository.create(mapper.map(propertyDTO, Property.class));

        return id;
    }

    @Override
    public TotalM2DTO calculateM2(int idProperty) throws PropertyNotFoundException {
        Property prop = iPropertyRepository.getById(idProperty);

        if(prop == null)
            throw new PropertyNotFoundException(idProperty);

        return new TotalM2DTO(prop.getProp_name(), calculateM2property(prop));
    }

    @Override
    public PricePropertyDTO calculatePrice(int idProperty) throws PropertyNotFoundException, DistrictNotFoundException {
        Property prop = iPropertyRepository.getById(idProperty);

        if(prop == null)
            throw new PropertyNotFoundException(idProperty);

        Double priceM2 = 0.0, m2 = 0.0, price = 0.0;

        m2 = calculateM2property(prop);
        priceM2 = iDistrictService.getById(prop.getDistrict_id()).getDistrict_price();

        price = m2 * priceM2;

        return new PricePropertyDTO(prop.getProp_name(), price);
    }

    @Override
    public EnvironmentBiggestDTO environmentBiggest(int idProperty) throws PropertyNotFoundException {
        Property prop = iPropertyRepository.getById(idProperty);

        if(prop == null)
            throw new PropertyNotFoundException(idProperty);

        Double m2environmentBiggest = 0.0;
        Environment environmentBiggest = null;

        for (Environment e: prop.getEnvironments()) {
            double auxM2 = calculateM2environment(e);
            if(auxM2 > m2environmentBiggest){
                environmentBiggest = e;
                m2environmentBiggest = auxM2;
            }
        }

        return new EnvironmentBiggestDTO(mapper.map(environmentBiggest, EnvironmentDTO.class));
    }

    @Override
    public M2perEnvironmentsDTO m2perEnvironments(int idProperty) throws PropertyNotFoundException {
        Property prop = iPropertyRepository.getById(idProperty);

        if(prop == null)
            throw new PropertyNotFoundException(idProperty);

        M2perEnvironmentsDTO resultDto = new M2perEnvironmentsDTO(new ArrayList<>());

        for (Environment e : prop.getEnvironments()) {
            EnvironmentM2DTO eDTO = new EnvironmentM2DTO();
            eDTO.setEnvironment_name(e.getEnvironment_name());
            eDTO.setM2(calculateM2environment(e));

            resultDto.getEnvironments().add(eDTO);
        }

        return resultDto;

    }

    //============

    private Double calculateM2property(Property prop){
        double tot=0;
        for (Environment e: prop.getEnvironments()) {
            tot += calculateM2environment(e);
        }
        return tot;
    }

    private Double calculateM2environment(Environment e){
        return e.getEnvironment_width() * e.getEnvironment_length();
    }
}
