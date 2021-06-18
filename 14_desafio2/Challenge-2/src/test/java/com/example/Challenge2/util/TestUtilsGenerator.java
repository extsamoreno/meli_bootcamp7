package com.example.Challenge2.util;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Services.DTOs.*;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestUtilsGenerator {

    public static Property getPropertyWith3Rooms(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",2.0, 4.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setDistrictId(id);
        property.setRooms(rooms);

        return property;
    }
    public static District get100USDollarsDistrict(Long id) {

        District district = new District(id,"District",100.0);

        return district;
    }

    Map<String, ErrorDTO> errors = new HashMap<>();
    public static Map<String, ErrorDTO> getDistrictPriceValidationError(){

        Map<String, ErrorDTO> errors = new HashMap<>();
        errors.put("pricePerM2", TestUtilsGenerator.getDistrictPriceError());

        return errors;
    }
    public static ErrorDTO getDistrictPriceError(){
        return new ErrorDTO("El precio maximo permitido por metro cuadrado no puede superar los 4000 U$S.","MethodArgumentNotValidException");
    }

    public static District get10000USDollarsDistrict(Long id) {

        District district = new District(id,"District",10000.0);

        return district;
    }
    public static Property get50MtProperty(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",2.0, 4.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setId(id);
        property.setRooms(rooms);

        return property;
    }

    public static Property getPropertyWith100M2BiggestRoom(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",10.0, 10.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setId(id);
        property.setRooms(rooms);

        return property;
    }
    public static Property getPropertyWith50M2BiggestRoom(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",10.0, 5.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setId(id);
        property.setRooms(rooms);

        return property;
    }
    public static Room get100Mt2Room() {

        Room room = new Room("Cocina", 10.0, 10.0);
        return room;
    }
    public static Room get25Mt2Room() {

        Room room = new Room("Cocina", 5.0, 5.0);
        return room;
    }
    public static List<Room> getTwo25Mt2Rooms() {
        Room room1 = new Room("Cocina", 5.0, 5.0);
        Room room2 = new Room("Living",5.0, 5.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        return rooms;
    }
    public static Property getPropertyWithTwo25MTsRooms(Long id){
        return new Property("Property",id,TestUtilsGenerator.getTwo25Mt2Rooms(),1L);
    }
    public static StructureDTO get101Mts2Structure(){
        return new StructureDTO(101.0,"Structure1");

    }
    public static StructureDTO get100Mts2Structure(){
        return new StructureDTO(100.0,"Structure1");

    }
    public static List<StructureDTO> getThree25Mts2Structures(){
        StructureDTO structure1 = new StructureDTO(25.0,"Structure1");
        StructureDTO structure2 = new StructureDTO(25.0,"Structure2");
        StructureDTO structure3 = new StructureDTO(25.0,"Structure3");


        List<StructureDTO> structures = new ArrayList<>();
        structures.add(structure1);
        structures.add(structure2);
        structures.add(structure3);

        return structures;
    }
    public static List<StructureDTO> getThree30Mts2Structures(){
        StructureDTO structure1 = new StructureDTO(30.0,"Structure1");
        StructureDTO structure2 = new StructureDTO(30.0,"Structure2");
        StructureDTO structure3 = new StructureDTO(30.0,"Structure3");


        List<StructureDTO> structures = new ArrayList<>();
        structures.add(structure1);
        structures.add(structure2);
        structures.add(structure3);

        return structures;
    }
    public static ValueDTO get1000USDValue(){
        return new ValueDTO(1000.0);
    }
    public static ValueDTO get10000USDValue(){
        return new ValueDTO(10000.0);
    }

    public static PropertyNotFoundException getPropertyNotFoundException(Long id){

        return new PropertyNotFoundException(id);

    }

    public static DistrictNotFoundException getDistrictNotFoundException(Long id){

        return new DistrictNotFoundException(id);

    }

    public static ErrorDTO getDistrictNotFoundError(Long id){

        DistrictNotFoundException e = new DistrictNotFoundException(id);
        return e.getError();

    }
    public static ErrorDTO getPropertyNotFoundError(Long id){

        PropertyNotFoundException e = new PropertyNotFoundException(id);
        return e.getError();

    }
}
