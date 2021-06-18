package com.example.testingchallengev2.model.request;

import com.example.testingchallengev2.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    @NotEmpty(message = "Empty name not allowed.")
    @Pattern(regexp = "[A-Z\\u00d1][\\ A-Za-zà-ÿ0-9\\u00f1]+",
            message = "Capitalized name required.")
    @Size(max = 30, message = "Name length must be 30 characters or less.")
    private String name;
    @NotEmpty(message = "Empty name not allowed.")
    @Pattern(regexp = "[A-Z1-9\\u00d1][\\ A-Za-zà-ÿ0-9\\u00f1]+",
            message = "Capitalized name required.")
    @Size(max = 45, message = "Name length must be 45 characters or less.")
    private String districtName;
    @NotEmpty(message = "Empty rooms not allowed.")
    @Size(min = 1, message = "House must have at least 1 room.")
    private ArrayList<RoomDTO> rooms;
}
