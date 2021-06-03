package boorcamp.spring.dos.demo.services;

import boorcamp.spring.dos.demo.dto.MetrosDTO;
import boorcamp.spring.dos.demo.dto.MoneyDTO;
import boorcamp.spring.dos.demo.dto.RoomDTO;
import boorcamp.spring.dos.demo.entidades.Home;
import boorcamp.spring.dos.demo.entidades.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HomeServices {

    public ArrayList<Home> homes;

    public MetrosDTO getAreaHome(Home h){
        double areaM2= 0;
        for (Room r:h.getRooms()) {
            areaM2 += r.getHeight()*r.getWidth();
        }
        return new MetrosDTO(h,areaM2);
    }


    public MoneyDTO getPrecioHome(Home h){
        double value= 0;
        for (Room r:h.getRooms()) {
            value += (r.getHeight()*r.getWidth())*800;
        }
        return new MoneyDTO(h,value);
    }

    public ArrayList<RoomDTO> getRoomsWithArea(Home h){
        ArrayList<RoomDTO> result = new ArrayList<>();
        for (Room r:h.getRooms()) {
            RoomDTO room= new RoomDTO(r.getName(),r.getWidth()*r.getHeight());
            result.add(room);
        }
        return result;
    }

    public Room getMaxRooms(Home h){
        Room result = null;
        double maxArea = 0;
        for (Room r:h.getRooms()) {
            if(r.getWidth()*r.getHeight()>maxArea){
                result=r;
            }
        }
        return result;
    }

}
