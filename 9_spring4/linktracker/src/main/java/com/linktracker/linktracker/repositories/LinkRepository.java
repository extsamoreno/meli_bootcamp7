package com.linktracker.linktracker.repositories;
import com.linktracker.linktracker.exceptions.LinkAlreadyExistException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.services.dtos.LinkDTO;

public interface LinkRepository {

    public int insertLink(String url,String password) throws LinkAlreadyExistException;
    public LinkDTO getLinkById(int linkId) throws LinkNotFoundException;
    public void addRedirect(int linkId);
    public LinkDTO invalidateLink(int linkId) throws LinkNotFoundException;

}
