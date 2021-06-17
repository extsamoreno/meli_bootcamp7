package com.tuCasita.tuCasita.unit;

import com.tuCasita.tuCasita.models.District;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class TestTuCasitaModels {

    @Test
    void houseNameCantBeNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidadHouse = new House(null, new District("Flores", 250d), new ArrayList<>());
        String errorMessage = "";

        Set<ConstraintViolation<House>> errors = validator.validate(invalidadHouse);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<House> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre de la casa no puede estar vacío.", errorMessage);
    }

    @Test
    void houseNameCantBeEmpty(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidadHouse = new House("", new District("Flores", 250d), new ArrayList<>());
        String errorMessage = "";

        Set<ConstraintViolation<House>> errors = validator.validate(invalidadHouse);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<House> error : errors ) {
            if (error.getMessage().equals("El nombre de la casa no puede estar vacío."))
                errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre de la casa no puede estar vacío.", errorMessage);
    }

    @Test
    void houseNameCantBeWithoutCapitalLetter(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidadHouse = new House("monoambiente", new District("Flores", 250d), new ArrayList<>());
        String errorMessage = "";

        //act
        Set<ConstraintViolation<House>> errors = validator.validate(invalidadHouse);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<House> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre de la casa debe comenzar con mayúscula.", errorMessage);
    }

    @Test
    void houseNameMaxLength(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidadHouse = new House("Dos ambientes con cocina y dormitorio ubicado en Capital Federal", new District("Flores", 250d), new ArrayList<>());
        String errorMessage = "";

        //act
        Set<ConstraintViolation<House>> errors = validator.validate(invalidadHouse);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<House> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("La longitud del nombre no puede superar los 30 caracteres.", errorMessage);
    }

    @Test
    void houseDistrictCantBeNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidadHouse = new House("Monoambiente", null, new ArrayList<>());
        String errorMessage = "";

        //act
        Set<ConstraintViolation<House>> errors = validator.validate(invalidadHouse);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<House> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("EL barrio no puede estar vacio", errorMessage);
    }

    @Test
    void districtNameCantBeNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        District invalidadDistrict = new District(null, 250d);
        String errorMessage = "";

        Set<ConstraintViolation<District>> errors = validator.validate(invalidadDistrict);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<District> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre del barrio no puede estar vacío.", errorMessage);
    }

    @Test
    void districtNameCantBeEmpty(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        District invalidadDistrict = new District("", 250d);
        String errorMessage = "";

        Set<ConstraintViolation<District>> errors = validator.validate(invalidadDistrict);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<District> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre del barrio no puede estar vacío.", errorMessage);
    }

    @Test
    void districtNameMaxLength(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        District invalidDistrict = new District("FloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFloresFlores", 250d);
        String errorMessage = "";

        //act
        Set<ConstraintViolation<District>> errors = validator.validate(invalidDistrict);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<District> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("La longitud del barrio no puede superar los 45 caracteres.", errorMessage);
    }

    @Test
    void districtPriceNotNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        District invalidDistrict = new District("Flores", null);
        String errorMessage = "";

        //act
        Set<ConstraintViolation<District>> errors = validator.validate(invalidDistrict);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<District> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El precio de un barrio no puede estar vacío.", errorMessage);
    }

    @Test
    void districtPriceMaxValue(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        District invalidDistrict = new District("Flores", 5000d);
        String errorMessage = "";

        //act
        Set<ConstraintViolation<District>> errors = validator.validate(invalidDistrict);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<District> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El precio maximo permitido por metro cuadrado no puede sueprar los 4000U$S", errorMessage);
    }

    @Test
    void roomNameCantBeNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room(null, 2d, 2d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre del ambiente no puede estar vacio", errorMessage);
    }

    @Test
    void roomNameCantBeEmpty(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("", 2d, 2d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            if (error.getMessage().equals("El nombre del ambiente no puede estar vacio"))
                errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre del ambiente no puede estar vacio", errorMessage);
    }

    @Test
    void roomNameCantBeWithoutCapitalLetter(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("comedor", 2d, 2d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El nombre del ambiente debe comenzar con mayúscula.", errorMessage);
    }

    @Test
    void roomNameMaxLength(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("Living-comdor que tiene cuatro metros cuadrados en  total", 2d, 2d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("La longitud del nombre no puede superar los 30 caracteres.", errorMessage);
    }

    @Test
    void roomWidthNotNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("Living", null, 2d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El ancho del ambiente no puede estar vacio", errorMessage);
    }

    @Test
    void roomWidthMaxValue(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("Living", 500d, 2d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El ancho maximo permitido por propiedad es de 25mts", errorMessage);
    }

    @Test
    void roomLengthNotNull(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("Living", 2d, null);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El largo del ambiente no puede estar vacio", errorMessage);
    }

    @Test
    void roomLengthMaxValue(){
        //arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room invalidRoom = new Room("Living", 2d, 500d);
        String errorMessage = "";

        Set<ConstraintViolation<Room>> errors = validator.validate(invalidRoom);
        errors.stream().forEach(error-> System.out.println(error.getMessage()));
        for (ConstraintViolation<Room> error : errors ) {
            errorMessage = error.getMessage();
        }

        //assert
        Assertions.assertEquals("El largo maximo permitido por propiedad es de 33mts", errorMessage);
    }
}
