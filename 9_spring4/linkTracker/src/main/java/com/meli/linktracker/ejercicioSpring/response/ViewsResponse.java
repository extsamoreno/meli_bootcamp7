package com.meli.linktracker.ejercicioSpring.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class ViewsResponse {
    private int linkid;
    private String link;
    private int views;
}
