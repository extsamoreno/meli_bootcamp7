package com.meli.TuCasitaTasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentListDTO {

        List< @Valid EnvironmentDTO> environments;

}
