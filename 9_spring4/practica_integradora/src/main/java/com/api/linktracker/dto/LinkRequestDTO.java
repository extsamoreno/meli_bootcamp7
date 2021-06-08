package com.api.linktracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LinkRequestDTO {

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Password")
    private String password;

}
