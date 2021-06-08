package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {

    private String url;
    private Boolean enabled;
    private Integer timesAccessed = 0;
    private String password;

}
