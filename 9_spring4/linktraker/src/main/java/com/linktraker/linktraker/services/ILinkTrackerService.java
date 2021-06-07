package com.linktraker.linktraker.services;

import com.linktraker.linktraker.exceptions.DisableException;
import com.linktraker.linktraker.exceptions.IncorrectPasswordException;
import com.linktraker.linktraker.exceptions.LinkIdNotFoundException;
import com.linktraker.linktraker.exceptions.LinkNotExistException;
import com.linktraker.linktraker.services.dtos.LinkDTO;
import com.linktraker.linktraker.services.dtos.LinkTrackerDTO;

public interface ILinkTrackerService {
    LinkDTO createLink(LinkTrackerDTO linkTrakerDTO) throws LinkNotExistException;

    String redirectById(int idLin, String password) throws IncorrectPasswordException, DisableException, LinkIdNotFoundException;

    LinkDTO statsLinksById(int idLink) throws LinkIdNotFoundException;

    LinkDTO invalidateLink(int idLink) throws LinkIdNotFoundException;
}
