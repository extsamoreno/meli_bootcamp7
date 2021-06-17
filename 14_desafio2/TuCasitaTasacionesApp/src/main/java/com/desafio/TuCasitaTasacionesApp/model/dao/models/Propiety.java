package com.desafio.TuCasitaTasacionesApp.model.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Propiety {
    private String name;
    private String neighborhood;
    private List<Room> roomList;
}
