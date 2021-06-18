package com.meli.desafio2.unit.repository;

import com.meli.desafio2.web.dto.request.EnvironmentDTO;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.repository.PropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PropertyRepositoryTest {

    @Test
    public void getPropertyByNameTest(){
        //arrange
        String env_name = "Livingroom";
        String env_name2 = "Bedroom";
        String env_name3 = "Bathroom2";
        double env1_width = 3;
        double env1_length = 2;
        double env2_width = 2;
        double env2_length =2;
        double env3_width = 2;
        double env3_length =1;
        List<Environment> environments = new ArrayList<>();
        environments.add(new Environment(env_name,env1_width,env1_length));
        environments.add(new Environment(env_name2,env2_width,env2_length));
        environments.add(new Environment(env_name3,env3_width,env3_length));
        Property expected = new Property();
        expected.setProp_name("Gatherons");
        expected.setDistrict("Salvaje");
        expected.setEnvironments(environments);
        PropertyRepository obj = new PropertyRepository();
        //act
        Property response = obj.getPropertyByName("Gatherons");
        //assert
        Assertions.assertEquals(expected,response);

    }
}
