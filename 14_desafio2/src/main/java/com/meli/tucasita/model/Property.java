package com.meli.tucasita.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
  private int id;
  private String name;
  private int districtId;
  private ArrayList<Environment> environments;
}
