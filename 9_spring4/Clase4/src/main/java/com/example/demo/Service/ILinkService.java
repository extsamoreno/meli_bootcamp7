package com.example.demo.Service;

import com.example.demo.Exception.BadPasswordExpection;
import com.example.demo.Exception.DuplicatedLinkException;
import com.example.demo.Exception.InvaidLinkException;
import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOMetric;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import com.example.demo.Model.Link;
import org.springframework.http.HttpHeaders;

import java.net.URISyntaxException;

public interface ILinkService {

    LinkDTOResponse creatLink(LinkDTOResquest linkDTOResquest) throws DuplicatedLinkException;

    HttpHeaders redirectLink(int id, String pass) throws LinkIdNotFoundException, URISyntaxException, InvaidLinkException, BadPasswordExpection;

    LinkDTOMetric metricsLink(int id) throws LinkIdNotFoundException, InvaidLinkException;

    void invalidateLink(int id) throws LinkIdNotFoundException, InvaidLinkException;
}
