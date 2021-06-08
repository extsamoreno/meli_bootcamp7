package ej1;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class House {
    private String name, address;
    private List<Room> rooms;
    private static final int WORTHSQUAREMETER = 800;


    public float calculateSquareMeters() {
        float square_meter = 0;
        if (rooms.size() > 0) {
            for (Room room: rooms) {
                square_meter += room.getSquareMeters();
            }
        }
        return square_meter;
    }

    public float calculateValue() {
        return calculateSquareMeters()*WORTHSQUAREMETER;
    }

    public Room getBiggestRoom() {
        Room biggest_room = null;
        if (rooms.size() > 0) {
            float biggest_m2 = 0;
            for (Room room: rooms) {
                if (biggest_m2 < room.getSquareMeters()) biggest_room = room;
            }
        }
        return biggest_room;
    }

    public List<RoomM2DTO> roomsSizeDTO() {

        List<RoomM2DTO> roomsdto = new ArrayList<>();
        if (rooms.size() > 0) {
            for (Room room: rooms) {
                roomsdto.add(new RoomM2DTO(room.getName(), room.getSquareMeters()));
            }
        }
        return roomsdto;
    }


}
