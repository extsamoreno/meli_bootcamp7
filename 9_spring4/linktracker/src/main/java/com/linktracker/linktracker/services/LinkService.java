package com.linktracker.linktracker.services;
import com.linktracker.linktracker.exceptions.InvalidLinkException;
import com.linktracker.linktracker.exceptions.LinkAlreadyExistException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.exceptions.LinkNotValidToRedirectException;
import com.linktracker.linktracker.services.dtos.LinkDTO;

public interface LinkService {
    public LinkDTO insertLink(String url,String password) throws InvalidLinkException, LinkAlreadyExistException;
    public LinkDTO redirectLink(int id,String password) throws LinkNotFoundException, LinkNotValidToRedirectException;
    public LinkDTO getLinkById(int id) throws LinkNotFoundException;
    public LinkDTO invalidateLink(int id) throws LinkNotFoundException;
}
