package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Name")
    private String name;

}
