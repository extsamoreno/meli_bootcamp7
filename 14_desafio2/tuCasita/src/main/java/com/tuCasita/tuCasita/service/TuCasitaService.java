package com.tuCasita.tuCasita.service;

import com.tuCasita.tuCasita.models.DTO.HouseDTO;
import com.tuCasita.tuCasita.models.DTO.ResponseRoomsDTO;
import com.tuCasita.tuCasita.models.DTO.RoomDTO;
import com.tuCasita.tuCasita.models.District;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;
import com.tuCasita.tuCasita.repository.iDistrictRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TuCasitaService implements iTuCasitaService{

    @Autowired
    iDistrictRepository repository;

    @Override
    public HouseDTO calculateTotalM2(House house) {
        validateDistrict(house.getDistrict());

        double[] result = new double[1];
        house.getRooms().stream().forEach(habitacion -> {
            result[0] += calculateM2(habitacion);
        });

        return (new HouseDTO(house.getName(), result[0]));
    }

    @Override
    public HouseDTO calculateHouseValue(House house) {
        validateDistrict(house.getDistrict());

        double[] result = new double[1];
        house.getRooms().stream().forEach(room -> {
            result[0] += calculateM2(room)*house.getDistrict().getPrice();
        });

        return new HouseDTO(house.getName(), result[0]);
    }

    @Override
    public Room biggestRoom(House house) {
        Room biggestRoom = new Room();
        double m2 = 0;

        for (Room room: house.getRooms()) {
            if (calculateM2(room) > m2){
                m2 = calculateM2(room);
                biggestRoom = room;
            }
        }
        return biggestRoom;
    }

    @Override
    public ResponseRoomsDTO calculateRoomM2 (House house){
        ArrayList<RoomDTO> m2Habitaciones = new ArrayList<>();

        for (Room room: house.getRooms())
            m2Habitaciones.add(new RoomDTO(room.getName(), calculateM2(room)));

        return new ResponseRoomsDTO(house.getName(), m2Habitaciones);
    }

    @Override
    public void validateDistrict (District district) {
        repository.getDistricts().get(district);
    }

    public static double calculateM2(Room room) {
        return (room.getWidth()*room.getLength());
    }
}
