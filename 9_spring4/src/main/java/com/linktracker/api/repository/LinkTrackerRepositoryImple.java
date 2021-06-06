package com.linktracker.api.repository;
import com.linktracker.api.dto.LinkDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Setter @Getter
public class LinkTrackerRepositoryImple implements LinktrackerRepository{
    private HashMap <Integer, LinkDTO> linkRepository = new HashMap<>();
    private Integer id=0;
}
