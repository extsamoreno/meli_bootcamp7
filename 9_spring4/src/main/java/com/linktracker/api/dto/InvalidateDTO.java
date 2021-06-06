package com.linktracker.api.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class InvalidateDTO {
    String url;
    int id;
    String state;
}
