package com.spring4.ejercicios.link.service;

import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.exception.InvalidLinkException;
import com.spring4.ejercicios.link.model.Link;
import com.spring4.ejercicios.link.repository.ILinkRepository;
import com.spring4.ejercicios.link.service.dto.request.LinkDTO;
import com.spring4.ejercicios.link.service.dto.response.IdDTO;
import com.spring4.ejercicios.link.service.dto.response.MetricsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    private Integer idGenerator = 100;

    @Autowired
    ILinkRepository linkRepositoryImpl;


    @Override
    public IdDTO createLink(LinkDTO linkDTO) {

        // Generate complete link
        idGenerator++;
        Link linkCreated = Mapper.toLink(linkDTO);
        linkCreated.setLinkId(idGenerator);

        // Save in DB
        linkRepositoryImpl.insertNewLink(linkCreated);

        // Return link ID and URL
        return Mapper.toIdDTO(linkCreated);
    }

    @Override
    public String getURLbyId(Integer id) throws InvalidLinkException, IdNotFoundException {
        Link link = linkRepositoryImpl.getLinkById(id);
        if(link.isLinkValid()){

            // Increase attribute Views in Link
            Integer currentViews = increaseViews(link);

            // Update the DB
            linkRepositoryImpl.updateViewsLink(id, currentViews);

            // Return the url in link
            String url = link.getLinkURL();
            return url;
        }
        else
            throw new InvalidLinkException(link.getLinkURL());
    }

    @Override
    public void changeStatusLink(Integer id) throws IdNotFoundException {
        linkRepositoryImpl.updateValidLink(id);
    }

    @Override
    public Integer increaseViews(Link link) {
        Integer oldViews = link.getLinkViews();
        link.setLinkViews(oldViews+1);
        return oldViews+1;
    }

    @Override
    public MetricsDTO getViews(Integer id) throws IdNotFoundException {
        Link link = linkRepositoryImpl.getLinkById(id);
        return Mapper.toMetricsDTO(link);
    }
}
