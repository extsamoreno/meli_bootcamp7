package com.spring4.ejercicios.link.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LinkDTO {

    private String url;
    private String password;

}
