package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipWithDataDTO extends OwnershipDTO {
    // TODO: 16/06/2021 builder pattern - one for district and other for rooms - deseable
    private DistrictDTO district;
    private List<RoomDTO> rooms;
}
