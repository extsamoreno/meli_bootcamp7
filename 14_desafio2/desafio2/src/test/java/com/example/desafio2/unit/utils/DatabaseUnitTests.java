package com.example.desafio2.unit.utils;

import com.example.desafio2.Desafio2Application;
import com.example.desafio2.project.utils.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class DatabaseUnitTests {

    @Test
    public void loadPropertiesDataBaseHappyPath(){
        //Arrange
        Database db = new Database();
        //Act
        db.loadPropertiesDataBase();

        //Asserts
        Assertions.assertTrue(Database.listProperties.size() > 0);
    }

    @Test
    public void loadDistrictsDataBaseHappyPath(){
        //Arrange
        Database db = new Database();
        //Act
        db.loadDistrictsDataBase();

        //Asserts
        Assertions.assertTrue(Database.listDistricts.size() > 0);
    }

    @Test
    public void Desafio2ApplicationMainHappyPath() throws Exception{
        //Arrange
        String[] strings = new String[]{"test"};

        //Act
        Desafio2Application.main(strings);
    }

}
