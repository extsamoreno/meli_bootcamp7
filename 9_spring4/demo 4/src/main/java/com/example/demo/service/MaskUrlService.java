package com.example.demo.service;

import com.example.demo.Exceptions.*;
import com.example.demo.repository.IUrlRepository;
import com.example.demo.repository.entities.Url;
import com.example.demo.service.dto.UrlDTO;
import com.example.demo.service.mapper.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class MaskUrlService implements IMaskUrlService {

    @Autowired
    IUrlRepository iUrlRepository;

    @Override
    public UrlDTO getLinkMetrics(Integer linkId) throws LinkNotFoundException {
        UrlDTO urlDTO = iUrlRepository.getItemLinkTrackerRepositoryById(linkId);
        if(urlDTO==null) throw new LinkNotFoundException(linkId);
        else return iUrlRepository.getItemLinkTrackerRepositoryById(linkId);
    }

    @Override
    public String getUrlNameByLink(Integer i, String pass) throws LinkNotFoundException, InvalidPassException, BloquedLinkException {
        UrlDTO urlDTO = iUrlRepository.getItemLinkTrackerRepositoryById(i);
        System.out.println("levante esto: " + urlDTO);
        if(urlDTO==null) throw new LinkNotFoundException(i);
        else return getUrlNameByLinkWithCheck(i, pass, urlDTO);
    }

    private String getUrlNameByLinkWithCheck(Integer i, String pass, UrlDTO savedUrl) throws InvalidPassException, BloquedLinkException {
        if(!savedUrl.getPass().equals(pass)) throw new InvalidPassException();
        if(!iUrlRepository.getItemLinkTrackerRepositoryById(i).getState()) throw new BloquedLinkException();
        iUrlRepository.updateLinkDTOCount(i);
        return iUrlRepository.getItemLinkTrackerRepositoryById(i).getUrl();
    }


    @Override
    public UrlDTO getLink(Url url) throws UrlNotValidException {
        if(isValid(url)) {
            iUrlRepository.openOrCreateLinkTackerRepository();
            Integer i = iUrlRepository.updateLinkTrackerRepository(url);
            return UrlMapper.toDTO(i ,url, url.getPass());
        }else{
            throw new UrlNotValidException();
        }
    }

    @Override
    public boolean isValid(Url url){
        try {
            new URL(url.getUrl()).toURI();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setInvalidLink(Integer i) throws DisableException {
        if(!iUrlRepository.invalidateLinkTrackerRepository(i)) throw new DisableException();// Es como si hiciera un delete en la base de datos
        return true;
    }

}

