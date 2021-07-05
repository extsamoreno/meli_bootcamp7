package com.meli.desafio2;

import com.meli.desafio2.DTOS.EnvironmentDTO;
import com.meli.desafio2.DTOS.PropertyDTO;
import lombok.Data;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseTest {
    protected static PropertyDTO payloadPropertyDTO;

    //Método para crear un objeto PropertyDTO antes de todas las pruebas, que se utilizará como entrada para cada prueba.

    @BeforeAll()
    public static void setUp(){
        // Environment initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Banio", 2, 2);

        // EnvironmentList initialize
        List<EnvironmentDTO> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);

        // Property initialize
        payloadPropertyDTO = new PropertyDTO("Alpaca", environments, "Alberdi", 1000.0);
    }

    @AfterAll()
    public static void tearDown(){
        payloadPropertyDTO = null;
    }
}
