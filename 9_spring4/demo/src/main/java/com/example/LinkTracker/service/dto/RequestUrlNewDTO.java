package com.example.LinkTracker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUrlNewDTO {
    private String value;
    private Optional<String> passsword;
}
