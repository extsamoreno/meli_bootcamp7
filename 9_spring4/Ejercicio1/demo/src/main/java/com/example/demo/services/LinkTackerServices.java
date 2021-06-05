package com.example.demo.services;

import com.example.demo.controller.exception.ExistLinkException;
import com.example.demo.controller.exception.NotFoundLinkException;
import com.example.demo.controller.exception.NotFoundLinkStatisticException;
import com.example.demo.controller.exception.NotValidURLException;
import com.example.demo.repository.ILinkTackerRepository;
import com.example.demo.services.DTO.LinkDTO;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;


@Service
public class LinkTackerServices implements ILinkTackerServices{

    @Autowired
    ILinkTackerRepository linkTackerRepository;

    @Override
    public LinkDTO newLink(LinkDTO linkDTO) throws NotValidURLException, ExistLinkException {

        UrlValidator validator = new UrlValidator();

        if (validator.isValid(linkDTO.getUrl())) {
           linkDTO= linkTackerRepository.newLink(linkDTO);
        }else{
            throw new NotValidURLException(linkDTO.getUrl());
        }

        return linkDTO;
    }

    @Override
    public HttpHeaders localRedirect(String linkId) throws NotFoundLinkException, URISyntaxException, NotValidURLException {
        LinkDTO linkDTO = linkTackerRepository.localRedirect(linkId);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (pingHost(linkDTO.getUrl(),60000)){
            URI url = new URI(linkDTO.getUrl());
            httpHeaders.setLocation(url);
            linkTackerRepository.addRegister(linkId);
        }else{
            throw new NotValidURLException(linkDTO.getUrl());
        }
        return httpHeaders;
    }

    @Override
    public Integer metrics(String linkId) throws NotFoundLinkStatisticException {
        Integer count = linkTackerRepository.metrics(linkId);
        if (count == null)
            throw new NotFoundLinkStatisticException(linkId);

        return count;
    }

    private boolean pingHost(String host,  int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, (host.contains("https")?443:80)), timeout);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
