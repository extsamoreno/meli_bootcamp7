package com.tuCasita.tuCasita.unit;

import com.tuCasita.tuCasita.exceptions.DistrictNotFoundError;
import com.tuCasita.tuCasita.exceptions.InvalidPriceException;
import com.tuCasita.tuCasita.models.DTO.HouseDTO;
import com.tuCasita.tuCasita.models.DTO.ResponseRoomsDTO;
import com.tuCasita.tuCasita.models.DTO.RoomDTO;
import com.tuCasita.tuCasita.models.District;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;
import com.tuCasita.tuCasita.repository.DistrictRepository;
import com.tuCasita.tuCasita.service.TuCasitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TestTuCasitaService {

    @Mock
    private DistrictRepository repository;
    @InjectMocks
    private TuCasitaService service;

    House house;
    District district;

    @BeforeEach
    void initHouse(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Living", 10d, 5d));
        rooms.add(new Room("Comedor", 6d, 4d));
        rooms.add(new Room("Habitacion", 15d, 9d));
        district = new District("Flores", 250d);
        house = new House("Monoambiente en Flores", district, rooms);
    }

    @Test
    void calculateTotalM2OK() {
        //arrange
        HouseDTO expected = new HouseDTO(house.getName(), 209d);
        HouseDTO obtained;

        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //act
        obtained = service.calculateTotalM2(house);

        //assert
        verify(repository, atLeastOnce()).getDistricts();
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void calculateHouseValueOK() {
        //arrange
        HouseDTO expected = new HouseDTO(house.getName(), 52250d);
        HouseDTO obtained;
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //act
        obtained = service.calculateHouseValue(house);

        //assert
        verify(repository, atLeastOnce()).getDistricts();
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void biggestRoomOK() {
        //arrange
        Room expected = new Room("Habitacion", 15d, 9d);
        Room obtained;
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //act
        obtained = service.biggestRoom(house);

        //assert
        verify(repository, atLeastOnce()).getDistricts();
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void calculateRoomM2OK() {
        //arrange
        ResponseRoomsDTO expected = new ResponseRoomsDTO("Monoambiente en Flores", new ArrayList<>(){{
            add(new RoomDTO("Living", 50d));
            add(new RoomDTO("Comedor", 24d));
            add(new RoomDTO("Habitacion", 135d));
        }});
        ResponseRoomsDTO obtained;
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //act
        obtained = service.calculateRoomM2(house);

        //assert
        verify(repository, atLeastOnce()).getDistricts();
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void validateDistrictOK() {
        //arrange
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //assert
        Assertions.assertTrue(service.validateDistrict(new District("Flores", 250d)));
        verify(repository, atLeastOnce()).getDistricts();

    }

    @Test
    void validateDistrictInvalidName() {
        //arrange
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //assert
        Assertions.assertThrows(DistrictNotFoundError.class, ()-> service.validateDistrict(new District("Parque Patricios", 100d)));
        verify(repository, atLeastOnce()).getDistricts();
    }

    @Test
    void validateDistrictInvalidPrice() {
        //arrange
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});

        //assert
        Assertions.assertThrows(InvalidPriceException.class, ()-> service.validateDistrict(new District("Flores", 100d)));
        verify(repository, atLeastOnce()).getDistricts();
    }

    @Test
    void calculateM2OK() {
        //arrange
        double expected = 50;
        double obtained;
        Room room = new Room("Living", 10d, 5d);

        //act
        obtained = service.calculateM2(room);

        //assert
        Assertions.assertEquals(expected, obtained);
    }
}
