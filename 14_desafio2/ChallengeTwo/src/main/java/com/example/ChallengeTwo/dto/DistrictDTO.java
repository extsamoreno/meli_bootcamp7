package com.example.ChallengeTwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {

    @NotEmpty(message = "The attribute 'districtName' must not be Null or Blank")
    @Size(min=1, max=45, message = "The length of the name no can exceed 45 characters.")
    private String districtName;

    @NotNull(message = "The  neighborhood's price does not it may be empty")
    @Min(value = 1, message = "The minimum price allowed per square meter is 1.")
    @Max(value = 4000, message = "The maximum price allowed per square meter no can exceed 4000.")
    private Double price;
}
