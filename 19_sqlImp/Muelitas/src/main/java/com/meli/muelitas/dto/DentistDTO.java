package com.meli.muelitas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private Long id;

    private String tag;

    private String name;

    private boolean active;

    private SpecialtyDTO specialtyDTO;

    private List<DentistAvailabilityDTO> dentistAvailabilityDTOList;

}
