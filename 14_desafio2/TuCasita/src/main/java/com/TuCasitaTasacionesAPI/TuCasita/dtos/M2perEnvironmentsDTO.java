package com.TuCasitaTasacionesAPI.TuCasita.dtos;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class M2perEnvironmentsDTO {
    List<EnvironmentM2DTO> environments;
}
