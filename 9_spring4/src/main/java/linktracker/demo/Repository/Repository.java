package linktracker.demo.Repository;

import linktracker.demo.Model.DTO.LinkDTO;
import lombok.Data;

import java.util.HashMap;

@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    HashMap<Integer, LinkDTO> linkDict = new HashMap<>();

    @Override
    public HashMap<Integer, LinkDTO> getDict() {
        return linkDict;
    }
}
