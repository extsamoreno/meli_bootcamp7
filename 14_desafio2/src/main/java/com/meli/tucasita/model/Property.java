package com.meli.tucasita.model;

import com.meli.tucasita.dto.EnvironmentDto;
import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
  private int id;
  private String name;
  private int districtId;
  private ArrayList<EnvironmentDto> environments;
}
