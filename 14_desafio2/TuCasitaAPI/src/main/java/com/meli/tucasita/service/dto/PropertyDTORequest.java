package com.meli.tucasita.service.dto;

import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTORequest {
    @Size(max = 30,message = "The property's name can't be larger than 30 length")
    @NotEmpty(message = "The property's name can't be null or empty")
    @Pattern(regexp = "^[A-Z].*", message = "The property's name must start with capital letter")
    private String name;
    @NotEmpty(message = "The property's district can't be null or empty")
    private String district;
    @NotEmpty(message = "The property's environments can't be null or empty")
    private List<@Valid Environment> environments;
}
