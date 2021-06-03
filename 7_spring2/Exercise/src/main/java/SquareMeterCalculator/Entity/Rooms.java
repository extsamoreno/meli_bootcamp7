package SquareMeterCalculator.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rooms {
    private String name;
    private int width;
    private int height;
}
