package com.example.ejerciciointegradorapi.project.services.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackerResponseDTO {
    private Integer linkId;
    private String url;
}

