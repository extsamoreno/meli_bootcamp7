package meli.bootcamp.tucasita.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnvironmentDTO {

    private String environment_name;

    private double environment_width;

    private double environment_length;

    private String  square_meters;

}
