package com.desafio.TuCasitaTasacionesApp.model.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Propiety {
    private String name;
    private String neighborhood;
    private List<Room> roomList;
}
