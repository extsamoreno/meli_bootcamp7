package com.example.tucasita.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class HouseWithLargestRoomDTO {
    private String name;
    private RoomWithMetersDTO largestRoom;
}
