package com.meli.tucasita.service.mapper;

import com.meli.tucasita.model.Property;
import com.meli.tucasita.service.dto.PropertyWithM2DTO;

public class Mapper {

    public static PropertyWithM2DTO toPropertyWithM2(Property property, double m2){
        PropertyWithM2DTO p= new PropertyWithM2DTO();
        p.setName(property.getName());
        p.setTotal_m2(m2);
        return p;
    }
}
