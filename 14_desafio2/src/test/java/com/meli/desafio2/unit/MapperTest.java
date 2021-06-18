package com.meli.desafio2.unit;

import com.meli.desafio2.web.dto.request.DistrictDTO;
import com.meli.desafio2.web.dto.request.EnvironmentDTO;
import com.meli.desafio2.web.dto.request.PropertyDTO;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.service.DistrictMapper;
import com.meli.desafio2.web.service.EnvironmentMapper;
import com.meli.desafio2.web.service.PropertyMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapperTest {
    @Test
    public void PropertyToModel(){
        //arrange
        Property expected = Utils.initValidProperty();
        PropertyDTO propertyDTO = Utils.initValidPropertyDTO();
        //act
        Property response = PropertyMapper.toModel(propertyDTO);
        //assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void PropertyToDTO(){
        //arrange
        PropertyDTO expected = Utils.initValidPropertyDTO();
        Property property = Utils.initValidProperty();

        //act
        PropertyDTO response = PropertyMapper.toDTO(property);

        //assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void DistrictToModel(){
        //arrange
        District expected = Utils.initValidDistrict();
        DistrictDTO districtDTO = Utils.initValidDistrictDTO();
        //act
        District response = DistrictMapper.toModel(districtDTO);
        //assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void DistrictToDTO(){
        //arrange
        DistrictDTO expected = Utils.initValidDistrictDTO();
        District district = Utils.initValidDistrict();
        //act
        DistrictDTO response = DistrictMapper.toDTO(district);
        //assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void EnvironmentToModel(){
        //arrange
        Environment expected = Utils.initValidEnvironment();
        EnvironmentDTO environmentDTO = Utils.initValidEnvironmentDTO();
        //act
        Environment response = EnvironmentMapper.toModel(environmentDTO);
        //assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void EnvironmentToDTO(){
        //arrange
        EnvironmentDTO expected = Utils.initValidEnvironmentDTO();
        Environment environment = Utils.initValidEnvironment();

        //act
        EnvironmentDTO response = EnvironmentMapper.toDTO(environment);

        //assert
        Assertions.assertEquals(expected,response);
    }

}
