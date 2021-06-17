package com.meli.tucasita.models;

import lombok.Data;

import java.util.List;

@Data
public class Property {

        private String name;
        private String district;
        private List<Room> rooms;

}
