package linktracker.demo.Repository;


import linktracker.demo.Model.DTO.LinkDTO;

import java.util.HashMap;

public interface IRepository {
    HashMap<Integer, LinkDTO> getDict();
}
