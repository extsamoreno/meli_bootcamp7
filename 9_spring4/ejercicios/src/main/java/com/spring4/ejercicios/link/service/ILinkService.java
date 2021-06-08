package com.spring4.ejercicios.link.service;

import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.exception.InvalidLinkException;
import com.spring4.ejercicios.link.model.Link;
import com.spring4.ejercicios.link.service.dto.request.LinkDTO;
import com.spring4.ejercicios.link.service.dto.response.IdDTO;
import com.spring4.ejercicios.link.service.dto.response.MetricsDTO;

public interface ILinkService {

    IdDTO createLink(LinkDTO linkDTO);

    String getURLbyId(Integer id) throws InvalidLinkException, IdNotFoundException;

    void changeStatusLink(Integer id) throws IdNotFoundException;

    Integer increaseViews(Link link);

    MetricsDTO getViews(Integer id) throws IdNotFoundException;

}
