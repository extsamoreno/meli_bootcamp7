package com.desafio2.testing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyModel {


    private String prop_name;
    private DistrictModel district;
    private ArrayList<RoomModel> rooms;
    private int cantRooms;



}
