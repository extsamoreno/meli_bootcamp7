package com.spring4.ejercicios.link.repository;

import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.model.Link;

public interface ILinkRepository {

    void insertNewLink(Link link);

    Link getLinkById(Integer id) throws IdNotFoundException;

    void updateValidLink(Integer id) throws IdNotFoundException;

    void updateViewsLink(Integer id, Integer views) throws IdNotFoundException;


}
