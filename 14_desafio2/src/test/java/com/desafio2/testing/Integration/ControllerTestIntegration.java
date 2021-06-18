package com.desafio2.testing.Integration;

import com.desafio2.testing.Dto.PropiedadRequestDTO;
import com.desafio2.testing.Model.PropertyModel;
import com.desafio2.testing.Repository.IDistrictRepository;
import com.desafio2.testing.Repository.IPropertyRepository;
import com.desafio2.testing.Service.IPropertyService;
import com.desafio2.testing.Service.Mapper.IPropertyMapper;
import com.desafio2.testing.Unit.UtilTest;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @MockBean
    IDistrictRepository iDistrictRepository;

    @MockBean
    IPropertyService iPropertyService;

    @Mock
    IPropertyMapper iPropertyMapper;



    @Test
    public void createPropertyHappyPath() throws Exception{
        PropiedadRequestDTO propiedadDto= UtilTest.createPropRequestDTO();
        PropertyModel property = UtilTest.createPropiedadModel();
        String propJson = UtilTest.toJson(propiedadDto);

        Mockito.when(iPropertyRepository.getPropertyByName(property.getProp_name())).thenReturn(property);
        Mockito.when(iPropertyService.getDistrictByName(propiedadDto.getDistrict_name())).thenReturn(property.getDistrict());
        Mockito.when(iPropertyRepository.addProperty(iPropertyMapper.toPropiedadModel(propiedadDto, property.getDistrict()))).thenReturn(true);


       this.mockMvc.perform(MockMvcRequestBuilders.post("/crearPropiedad")
                .contentType(MediaType.APPLICATION_JSON)
                .content(propJson))
                .andDo(print()).andExpect(status().isOk());


    }


}
