package com.linktracker.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter @Setter
public class RedirectDTO {
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;
}
