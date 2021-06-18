package com.tucasita.tasaciones.unit.utils;

import com.tucasita.tasaciones.project.utils.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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



}
