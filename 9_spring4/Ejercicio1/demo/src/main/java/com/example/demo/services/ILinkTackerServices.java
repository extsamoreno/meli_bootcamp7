package com.example.demo.services;

import com.example.demo.controller.exception.ExistLinkException;
import com.example.demo.controller.exception.NotFoundLinkException;
import com.example.demo.controller.exception.NotFoundLinkStatisticException;
import com.example.demo.controller.exception.NotValidURLException;
import com.example.demo.services.DTO.LinkDTO;
import org.springframework.http.HttpHeaders;

import java.net.URISyntaxException;

public interface ILinkTackerServices {

    LinkDTO newLink(LinkDTO linkDTO) throws NotValidURLException, ExistLinkException;

    HttpHeaders localRedirect(String linkId) throws NotFoundLinkException, URISyntaxException, NotValidURLException;

    Integer metrics (String linkId) throws NotFoundLinkStatisticException;
}
