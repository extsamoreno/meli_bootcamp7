package com.meli.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomsDTO {

    @Valid
    private List<RoomDTO> rooms;

}
