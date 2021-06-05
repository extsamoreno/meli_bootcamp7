package com.example.demo.Service;


import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import com.example.demo.Model.Link;
import com.example.demo.Model.Mapper.LinkMapper;
import com.example.demo.Repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkDTOResponse creatLink(LinkDTOResquest linkDTOResquest) {
        int id = iLinkRepository.getArraySize();
        Link link = LinkMapper.toLink(linkDTOResquest, id);
        iLinkRepository.addLink(link);
        return LinkMapper.toDTO(link);
    }

    @Override
    public HttpHeaders redirectLink(int id) throws LinkIdNotFoundException, URISyntaxException {
        URI uri = new URI(iLinkRepository.getLinkByID(id).getLink());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return httpHeaders;
    }

    /*
    @Override
    public String redirectLink(int id) throws LinkIdNotFoundException {

        return redirectView;
    }
    */

}
