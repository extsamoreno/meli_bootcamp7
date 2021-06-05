package com.example.demo.repository;

import com.example.demo.controller.exception.ExistLinkException;
import com.example.demo.controller.exception.NotFoundLinkException;
import com.example.demo.services.DTO.LinkDTO;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkTackerRepository {

    LinkDTO newLink(LinkDTO linkDTO) throws ExistLinkException;

    LinkDTO localRedirect(String linkId) throws NotFoundLinkException;

    void addRegister(String linkId);

    Integer metrics (String linkId);
}
