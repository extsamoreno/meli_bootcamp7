package com.meli.linktracker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTORequest {
    private String url, password;
}
