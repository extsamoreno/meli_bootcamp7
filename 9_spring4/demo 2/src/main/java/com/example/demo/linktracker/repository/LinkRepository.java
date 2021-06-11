package com.example.demo.linktracker.repository;

import com.example.demo.linktracker.repository.ILinkRepository;
import com.example.demo.linktracker.service.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class LinkRepository implements ILinkRepository {
    ArrayList<LinkDTO> arrayList = new ArrayList<>();
    int count =0;

    @Override
    public int getLinkId(String url) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setUrl(url);
        linkDTO.setLinkId(arrayList.size()+1);
        boolean isPresente =false;
        if (arrayList.size()>0) {
            for (int i=0; i<arrayList.size();i++) {
                if (url.equals(arrayList.get(i)))
                    isPresente=true;
            }
            if (!isPresente)
                arrayList.add(linkDTO);
        }
        else
            arrayList.add(linkDTO);
        return arrayList.size();
    }

    @Override
    public String getLink(int linkId) {
        String link = arrayList.get(linkId-1).getUrl();
        return link;
    }
}
