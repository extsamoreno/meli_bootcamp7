package com.example.linktracker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLinkDTO {

    private Integer id;
    private String url;
    private int consultTimes;
    private boolean active;
}
