package com.example.ChallengeTwo.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {

    @NotEmpty(message = "The attribute 'environmentName' must not be Null or Blank")
    @Size(min=1, max=30, message = "The length of the name no can exceed 30 characters.")
    @Pattern(regexp = "^[A-Z].*$", message="The attribute 'environmentName' must start in uppercase")
    private String environmentName;

    @NotNull(message = "The width of the environment is not it may be empty.")
    @Max(value = 25, message = "The maximum width allowed per property is 25 meters.")
    @Min(value = 1, message = "The minimum width allowed per property is 1 meter.")
    private Double environmentWidth;

    @NotNull(message = "The Length of the environment is not it may be empty.")
    @Max(value = 33, message = "The maximum length allowed per property is 33 meters.")
    @Min(value = 1, message = "The minimum length allowed per property is 1 meter.")
    private Double environmentLength;


    public double getTotalArea(){
        return environmentLength*environmentWidth;
    }
}
