package com.example.springclase4.project.service;

import com.example.springclase4.project.exception.UrlAlreadyExistException;
import com.example.springclase4.project.exception.UrlNotFoundException;
import com.example.springclase4.project.model.Url;
import com.example.springclase4.project.repository.DTO.UrlSavedDTO;
import com.example.springclase4.project.repository.DTO.UrlMetricsDTO;
import com.example.springclase4.project.repository.DTO.UrlRequestDTO;
import com.example.springclase4.project.repository.IUrlRepository;
import com.example.springclase4.project.service.Mapper.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;


@Service
public class UrlService implements IUrlService{

    @Autowired
    IUrlRepository iUrlRepository;

    @Override
    public UrlSavedDTO saveUrl(UrlRequestDTO link) throws UrlAlreadyExistException {
        if(urlExist(link))
        {
            throw new UrlAlreadyExistException(link);
        }
        Url url = iUrlRepository.createUrl(UrlMapper.toUrlModel(link));
        return UrlMapper.toUrlSavedDTO(url);
    }

    @Override
    public HashMap<Integer, Url> getUrlsList() {
        return iUrlRepository.getUrlsList();
    }

    @Override
    public UrlMetricsDTO getRedirected(String linkId) throws UrlNotFoundException{
        try
        {
            Url url = iUrlRepository.getUrlById(Integer.parseInt(linkId));
            //Redireccionar...
            return null;
        }
        catch (Exception e)
        {
            throw new UrlNotFoundException(linkId);
        }
    }

    @Override
    public UrlMetricsDTO getUrlMetrics(String linkId) throws UrlNotFoundException {
        Url url = iUrlRepository.getUrlById(Integer.parseInt(linkId));

        if (url == null) {
            throw new UrlNotFoundException(linkId);
        } else {
            return UrlMapper.toUrlMetricsDto(url);
        }
    }

    @Override
    public Boolean urlExist(UrlRequestDTO link) {
        Collection<Url> urls = getUrlsList().values();
        Boolean r = false;
        for (Url url :
                urls) {
            if(url.getUrl().equals(link.getUrl()))
            {
                r = true;
            }
        }
        return r;
    }

    @Override
    public Boolean invalidateUrl(Url url) {
        return null;
    }

    @Override
    public Boolean setValidUrl(Url url) {
        return null;
    }


    /*

    private boolean validateUrl(String url){
        final String URL_REGEX =
                "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                        "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                        "([).!';/?:,][[:blank:]])?$";

        final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
        if (url == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

     */
}
