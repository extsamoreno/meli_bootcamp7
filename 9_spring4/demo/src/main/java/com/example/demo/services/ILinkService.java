package com.example.demo.services;

import com.example.demo.dtos.LinkDTO;
import com.example.demo.dtos.UrlDTO;
import com.example.demo.exceptions.LinkDeactivetedException;
import com.example.demo.exceptions.NotAuthorizedException;
import com.example.demo.exceptions.UrlNotValidException;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

public interface ILinkService {

    String add(UrlDTO req) throws UrlNotValidException, IOException;

    RedirectView redirect(int id, String psw) throws LinkDeactivetedException, NotAuthorizedException;

    LinkDTO getMetrics(int id);

    String invalidateLink(int id);
}
