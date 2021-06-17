package com.example.tucasita.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class HouseWithLargestRoom {
    private String name;
    private RoomWithMetersDTO largestRoom;
}
