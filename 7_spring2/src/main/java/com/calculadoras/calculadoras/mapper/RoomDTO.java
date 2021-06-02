package com.calculadoras.calculadoras.mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
public class RoomDTO {
    String name;
    int meters;
}
