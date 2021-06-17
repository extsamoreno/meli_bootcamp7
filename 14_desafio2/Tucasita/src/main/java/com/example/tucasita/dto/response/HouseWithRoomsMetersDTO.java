package com.example.tucasita.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class HouseWithRoomsMetersDTO {
    private String name;
    private List<RoomWithMetersDTO> rooms;
}
