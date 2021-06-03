package boorcamp.spring.dos.demo.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {

    private String name;
    private String address;
    private ArrayList<Room> rooms;


}
