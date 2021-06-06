package com.spring4.spring4.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkMetricDTO {
    private String url;
    private int redirections;
    private boolean active;
}
