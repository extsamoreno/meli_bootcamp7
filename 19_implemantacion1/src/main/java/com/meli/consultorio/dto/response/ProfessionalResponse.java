package com.meli.consultorio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProfessionalResponse {
    private Integer pro_id;
    private String pro_name;
    private String pro_last_name;
}
