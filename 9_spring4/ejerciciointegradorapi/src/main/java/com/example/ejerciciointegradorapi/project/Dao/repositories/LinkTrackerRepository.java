package com.example.ejerciciointegradorapi.project.Dao.repositories;

import com.example.ejerciciointegradorapi.project.Dao.models.LinkTracker;
import com.example.ejerciciointegradorapi.project.exceptions.InvalidUrlException;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerResponseDTO;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;


@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    HashMap<Integer,LinkTracker> linkTrackerHashMap = new HashMap<>();
    private Integer linkIdCont=0;

    @Override
    public LinkTracker saveUrl (String url) throws InvalidUrlException {
        LinkTracker linkTracker = new LinkTracker(linkIdCont,url);
        linkTrackerHashMap.put(linkIdCont,linkTracker);
        linkIdCont++;
        return linkTracker;
    }

    @Override
    public LinkTracker addRedirect (Integer linkId) throws InvalidUrlException {
        if(linkTrackerHashMap.get(linkId).getInvalidate()==false){
            Integer actualRedirectTimes = linkTrackerHashMap.get(linkId).getRedirectCounter();
            linkTrackerHashMap.get(linkId).setRedirectCounter(actualRedirectTimes+1);
        }
        return getByLinkId(linkId);

    }

    @Override
    public LinkTracker getByLinkId(Integer linkId) throws InvalidUrlException {
        if (linkTrackerHashMap.get(linkId)==null || linkTrackerHashMap.get(linkId).getInvalidate()==true)
            throw new InvalidUrlException(linkId.toString());
        return linkTrackerHashMap.get(linkId);
    }

    @Override
    public void invalidateByLinkId(Integer linkId) {
        linkTrackerHashMap.get(linkId).setInvalidate(true);
    }


}
