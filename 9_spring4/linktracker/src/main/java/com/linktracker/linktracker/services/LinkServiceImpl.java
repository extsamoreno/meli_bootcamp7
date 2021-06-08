package com.linktracker.linktracker.services;
import com.linktracker.linktracker.exceptions.InvalidLinkException;
import com.linktracker.linktracker.exceptions.LinkAlreadyExistException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.exceptions.LinkNotValidToRedirectException;
import com.linktracker.linktracker.repositories.LinkRepository;
import com.linktracker.linktracker.services.dtos.LinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkRepository linkRepository;

    @Override
    public LinkDTO insertLink(String url,String password) throws LinkAlreadyExistException, InvalidLinkException {
        return new LinkDTO(
                url,password,linkRepository.insertLink(url,password),0,true
        );
    }

    public LinkDTO getLinkById(int id) throws LinkNotFoundException {
        return linkRepository.getLinkById(id);
    }

    @Override
    public LinkDTO invalidateLink(int id) throws LinkNotFoundException {
        return linkRepository.invalidateLink(id);
    }

    @Override
    public LinkDTO redirectLink(int id,String password) throws LinkNotFoundException, LinkNotValidToRedirectException {
        LinkDTO linkDTO =  linkRepository.getLinkById(id);
        if(!linkDTO.getPassword().equals(password)){
            return null;
        }

        if(!linkDTO.isValid()){
            throw new LinkNotValidToRedirectException("Link no valido para redireccionar");
        }

        linkRepository.addRedirect(id);
        return linkDTO;
    }

}
