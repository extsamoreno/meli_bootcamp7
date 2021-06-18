package com.didney.junit.tucasitatasaciones.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalValuePropertyByEnvironmentDTOResponse {
    private HttpStatus status;
    private double totalValueProperty;
}
