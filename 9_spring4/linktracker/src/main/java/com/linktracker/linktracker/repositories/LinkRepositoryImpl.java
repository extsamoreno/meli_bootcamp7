package com.linktracker.linktracker.repositories;
import com.linktracker.linktracker.exceptions.LinkAlreadyExistException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.services.dtos.LinkDTO;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    HashMap<Integer, LinkDTO> links = new HashMap<>();
    int idLink = -1;

    @Override
    public int insertLink(String url,String password) throws LinkAlreadyExistException {

            for (LinkDTO link: links.values()) {
                if(link.getLink().equals(url)){
                    throw new LinkAlreadyExistException(url);
                }
            }

        idLink++;
        links.put(idLink,new LinkDTO(url,password,idLink,0,true));
        return idLink;
    }

    public void addRedirect(int linkId){
        links.get(linkId).setCounterRedirect(
                links.get(linkId).getCounterRedirect()+1
        );
    }

    @Override
    public LinkDTO invalidateLink(int linkId) throws LinkNotFoundException{
        LinkDTO linkDTO = getLinkById(linkId);
        links.get(linkId).setValid(false);
        return links.get(linkId);
    }

    @Override
    public LinkDTO getLinkById(int linkId) throws LinkNotFoundException {
        if(!links.containsKey(linkId)){
            throw new LinkNotFoundException("404 El link no existe");
        }
        return links.get(linkId);
    }

}
