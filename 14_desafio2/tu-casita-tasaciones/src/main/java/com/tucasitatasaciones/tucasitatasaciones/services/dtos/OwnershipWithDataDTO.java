package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipWithDataDTO extends OwnershipDTO {
    // TODO: 16/06/2021 builder pattern - one for district and other for rooms - deseable
    @NotNull(message = "El barrio no puede estar vacío.")
    private @Valid DistrictDTO district;
    @NotNull(message = "Debe agregar al menos una habitación.")
    private List<@Valid RoomDTO> rooms;
}
