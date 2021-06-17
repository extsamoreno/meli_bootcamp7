package com.meli.tucasita.model;

import com.meli.tucasita.dto.EnvironmentDto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
  private int id;
  private String name;
  private int districtId;
  private List<EnvironmentDto> environments;
}
