package com.example.demo.linktracker.repository;

import com.example.demo.linktracker.repository.ILinkRepository;
import com.example.demo.linktracker.service.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository {
    ArrayList<LinkDTO> arrayList = new ArrayList<>();
    HashMap<Integer,Integer> metrics = new HashMap<>();

    @Override
    public int getLinkId(String url) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setUrl(url);
        linkDTO.setLinkId(arrayList.size()+1);
        boolean isPresente =false;
        if (arrayList.size()>0) {
            for (int i=0; i<arrayList.size();i++) {
                if (url.equals(arrayList.get(i).getUrl()))
                    isPresente=true;
            }
            if (!isPresente)
                arrayList.add(linkDTO);
        }
        else
            arrayList.add(linkDTO);
        metrics.put(arrayList.size(), 0);
        return arrayList.size();
    }

    @Override
    public String getLink(int linkId) {
        String link = arrayList.get(linkId-1).getUrl();
        metrics.replace(linkId, metrics.get(linkId)+1);
        return link;
    }

    @Override
    public int getMetric(int linkId) {
        return metrics.get(linkId);
    }
}
