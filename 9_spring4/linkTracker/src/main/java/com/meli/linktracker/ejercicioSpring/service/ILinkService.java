package com.meli.linktracker.ejercicioSpring.service;

import com.meli.linktracker.ejercicioSpring.dto.LinkDTO;
import com.meli.linktracker.ejercicioSpring.model.Link;
import com.meli.linktracker.ejercicioSpring.repository.ILinkRepository;
import com.meli.linktracker.ejercicioSpring.response.LinkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public interface ILinkService {
    public LinkResponse crearLink(LinkDTO linkDTO, String password);
    public List<Link> getLinkList();
    public Link getLinkById(int id);
    public RedirectView redirect(int id);
    public void setView(int linkid);
    public int getView(int linkid);
}
