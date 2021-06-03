package SquareMeterCalculator.Entity;

import lombok.Data;
import java.util.List;

@Data
public class House {
    private int id;
    private String name;
    private String address;
    private List<Rooms> rooms;

    public House(){
    }
    public House(int id,String name,String address,List<Rooms> rooms){
        this.id=id;
        this.name=name;
        this.address=address;
        this.rooms = rooms;
    }
    public House(String name,String address,List<Rooms> rooms){
        this.id=0;
        this.name=name;
        this.address=address;
        this.rooms = rooms;
    }
}
