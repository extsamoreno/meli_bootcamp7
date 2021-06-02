package com.apiSpring3.entity;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class House {
    private String name;
    private String address;
    private Room[] rooms;

    public static double calculateTotalSquareMeters(Room[] rooms){
        double total = 0;
        for (var room : rooms){
            total+= room.getLength()*room.getWidth();
        }
        return total;
    }

    public static double calculateTotalValue(House house) {
        return calculateTotalSquareMeters(house.getRooms())*800;
    }

    public static Room getBiggestRoom(House house) {
        var rooms = house.getRooms();
        Room biggestRoom = rooms[0];

        for (int i = 1; i < rooms.length; i++) {
            if (rooms[i].getLength()*rooms[i].getWidth()
            > biggestRoom.getLength()* biggestRoom.getWidth()){
                biggestRoom = rooms[i];
            }
        }
        return biggestRoom;
    }
}
