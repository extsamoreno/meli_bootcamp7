package com.example.demo.Service;

import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URISyntaxException;

public interface ILinkService {

    LinkDTOResponse creatLink(LinkDTOResquest linkDTOResquest);

    HttpHeaders redirectLink(int id) throws LinkIdNotFoundException, URISyntaxException;

}
