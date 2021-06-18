package com.example.desafio2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Desafio2ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void Desafio2ApplicationMainHappyPath(){
        //Arrange
        String[] strings = new String[]{"test"};

        //Act
        Desafio2Application.main(strings);
    }
}
