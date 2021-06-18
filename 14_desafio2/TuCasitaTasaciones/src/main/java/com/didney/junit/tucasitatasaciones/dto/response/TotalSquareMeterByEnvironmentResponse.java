package com.didney.junit.tucasitatasaciones.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalSquareMeterByEnvironmentResponse {
    HttpStatus status;
    List<EnvironmentSquareMeterResponse> environments;
}
