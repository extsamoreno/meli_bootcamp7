package com.meli.calculatorHouseSquareMeters.model.dto;

import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseRequestDTO {

    @NotNull(message = "The attribute 'houseName' must not be Null")
    @Size(min = 1, max = 30, message = "The 'houseName' attribute cannot exceed 30 characters")
    @NotEmpty(message = "The 'houseName' attribute must not be empty")
    @Pattern(regexp = "^[A-Z].*$", message="The attribute 'houseName' must start in uppercase")
    private String houseName;

    @NotEmpty(message = "The attribute 'districtName' must not be Null")
    @Size(min = 1, max = 45, message = "The 'districName' attribute cannot exceed 45 characters")
    @NotEmpty(message = "The 'districtName' attribute must not be empty")
    private String districtName;

    @NotNull(message = "The atribute 'rooms' must not be null")
    @Size(min = 1, message = "Minimum length of rooms is 1")
    @Valid
    private ArrayList<Room> rooms;
}
