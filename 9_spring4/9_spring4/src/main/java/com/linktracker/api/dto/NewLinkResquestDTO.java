package com.linktracker.api.dto;

import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class NewLinkResquestDTO {
    private String url;
    private String password;
}
