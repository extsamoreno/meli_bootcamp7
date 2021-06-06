package com.spring4.spring4.Services;

import com.spring4.spring4.DTOs.LinkMetricDTO;
import com.spring4.spring4.DTOs.LinkRequestDTO;
import com.spring4.spring4.DTOs.LinkResponseDTO;
import com.spring4.spring4.Exceptions.InvalidLinkPassException;
import com.spring4.spring4.Exceptions.LinkInactiveException;
import com.spring4.spring4.Exceptions.LinkNotFoundException;
import com.spring4.spring4.Models.Link;
import com.spring4.spring4.Repositories.ILinkTrackerRepository;
import com.spring4.spring4.Services.Mappers.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LinkTrackerService implements ILinkTrackerService{
    @Autowired
    ILinkTrackerRepository iLinkTrackerRepository;

    @Override
    public LinkResponseDTO create(LinkRequestDTO linkDTOreq) {
        Link link = iLinkTrackerRepository.create(LinkMapper.linkDtoRequestCreateToLink(linkDTOreq));
        return LinkMapper.linkTolinkDtoResponseCreated(link);
    }

    @Override
    public void redirect(HttpServletResponse response, int id, String pass) throws IOException, LinkNotFoundException, LinkInactiveException, InvalidLinkPassException {
        Link link = iLinkTrackerRepository.getLink(id);

        if(isPassValid(id, pass, link)){
            if(link.getActive() == true){
                response.sendRedirect(link.getUrl());
                iLinkTrackerRepository.addRedirectionCont(link);
            }else{
                throw new LinkInactiveException(id);
            }
        }
        else{
            throw new InvalidLinkPassException(id);
        }

    }

    @Override
    public LinkMetricDTO getMetricByLink(int id, String pass) throws LinkNotFoundException, InvalidLinkPassException {
        Link link = iLinkTrackerRepository.getLink(id);

        if(isPassValid(id, pass, link))
            return LinkMapper.linkToLinkMetricDto(link);
        else
            throw new InvalidLinkPassException(id);

    }

    @Override
    public void invalidate(int id, String pass) throws LinkNotFoundException, InvalidLinkPassException {
        Link link = iLinkTrackerRepository.getLink(id);
        if(isPassValid(id, pass, link))
            iLinkTrackerRepository.invalidate(id);
        else
            throw new InvalidLinkPassException(id);
    }

    private boolean isPassValid(int id, String pass, Link link){
        if(link.getId().equals(id) && link.getPass().equals(pass))
            return true;
        else
            return false;
    }

}
