package com.example.demo.Service;


import com.example.demo.Exception.BadPasswordExpection;
import com.example.demo.Exception.DuplicatedLinkException;
import com.example.demo.Exception.InvaidLinkException;
import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOMetric;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import com.example.demo.Model.Link;
import com.example.demo.Model.Mapper.LinkMapper;
import com.example.demo.Repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkDTOResponse creatLink(LinkDTOResquest linkDTOResquest) throws DuplicatedLinkException {
        int id = iLinkRepository.getArraySize();
        Link link = LinkMapper.toLink(linkDTOResquest, id);
        iLinkRepository.addLink(link);
        return LinkMapper.toDTO(link);
    }

    @Override
    public HttpHeaders redirectLink(int id, String pass) throws LinkIdNotFoundException, URISyntaxException, InvaidLinkException, BadPasswordExpection {
        Link link = iLinkRepository.getLinkByID(id);
        HttpHeaders httpHeaders;
        if(link.getPassword().equals(pass)){
            link.increaseCount();
            URI uri = new URI(link.getLink());
            httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
        }else throw new BadPasswordExpection();
        return httpHeaders;
    }

    @Override
    public LinkDTOMetric metricsLink(int id) throws LinkIdNotFoundException, InvaidLinkException {
        Link link = iLinkRepository.getLinkByID(id);
        return LinkMapper.toMetric(link);
    }

    @Override
    public void invalidateLink(int id) throws LinkIdNotFoundException, InvaidLinkException {
        Link link = iLinkRepository.getLinkByID(id);
        link.setStatus(false);
    }

}
