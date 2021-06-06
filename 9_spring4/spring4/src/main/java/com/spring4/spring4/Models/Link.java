package com.spring4.spring4.Models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String pass;
    private Boolean active;
    private int redirections;
}
