package com.example.testingchallengev2.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    @NotEmpty(message = "Empty name not allowed.")
    @Pattern(regexp = "[A-Z\\u00d1][\\ A-Za-zà-ÿ0-9\\u00f1]+",
            message = "Capitalized name required.")
    @Size(max = 30, message = "Name length must be 30 characters or less.")
    private String name;

    @NotNull(message = "Empty width not allowed.")
    @DecimalMax(value = "25.0",
            message = "Width higher than 25mts are not allowed.")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "House's room must have a minimum width.")
    private double width;

    @NotNull(message = "Empty length not allowed.")
    @DecimalMax(value = "33.0",
            message = "Length higher than 33mts are not allowed.")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "House's room must have a minimum length.")
    private double length;
}
