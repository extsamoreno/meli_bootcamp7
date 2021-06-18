package meli.bootcamp.tucasita.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyResponseDTO {

    private Double meters;
    private Double price;
    private PropertyDTO property;

}
