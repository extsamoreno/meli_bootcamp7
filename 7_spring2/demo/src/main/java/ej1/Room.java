package ej1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private String name;
    private float width, length;

    public float getSquareMeters() {
        if (width > 0 && length > 0) return width*length;
        return 0;
    }
}
