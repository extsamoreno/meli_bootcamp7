package com.didney.junit.tucasitatasaciones.dto.response;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTOResponse {
    private String propertyName;
    private List<EnvironmentDTO> environmentDTOS;
}
