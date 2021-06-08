package com.example.LinkTracker.repository;

import com.example.LinkTracker.service.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private final HashMap<Integer,LinkDTO> mapLinks = new HashMap<>();


    @Override
    public LinkDTO save(LinkDTO link) {
        if(link.getLinkId()== null){
            link.setLinkId(mapLinks.values().size());
        }
        mapLinks.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public LinkDTO findByLinkId(Integer id) {
        LinkDTO linkResult = mapLinks.get(id);
        return linkResult;
    }

    @Override
    public void delete(LinkDTO linkDTO) {
        mapLinks.remove(linkDTO.getLinkId());
    }
}
