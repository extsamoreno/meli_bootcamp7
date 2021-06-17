package com.example.ChallengeTwo.dto;

import com.example.ChallengeTwo.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {


    @NotEmpty(message = "The attribute 'houseName' must not be Null or Blank")
    @Size(min=1, max=30, message = "The length of the name no can exceed 30 characters.")
    @Pattern(regexp = "^[A-Z].*$", message="The attribute 'houseName' must start in uppercase")
    private String houseName;

    @NotEmpty(message = "The attribute 'districName' must not be Null or Blank")
    @Size(min=1, max=45, message = "The length of the name no can exceed 45 characters.")
    private String districName;

    @NotNull(message = "The  'Environments' must not be Null or Blank")
    @Valid
    private List< Environment> listEnvironment;
}
