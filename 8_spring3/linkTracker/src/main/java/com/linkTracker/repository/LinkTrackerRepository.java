package com.linkTracker.repository;

import com.models.LinkDTO;
import com.models.UrlDTO;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkTrackerRepository implements iLinkTrackerRepository {

    private HashMap<Integer, LinkDTO> links;
    private AtomicInteger linkId = new AtomicInteger(1);

    @Override
    public UrlDTO saveLink(String url) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setUrl(url);
        links.put(this.linkId.getAndIncrement(), linkDTO);
        return new UrlDTO(url, this.linkId.get());
    }

    @Override
    public UrlDTO saveLink(String url, String password) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setUrl(url);
        linkDTO.setPassword(password);
        links.put(this.linkId.getAndIncrement(), linkDTO);
        return new UrlDTO(url, this.linkId.get());
    }


    @Override
    public LinkDTO getLinkDto (Integer linkId){
        return this.links.get(linkId);
    }

}
