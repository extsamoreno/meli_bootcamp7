package com.example.springclase4.practicaintegradoratm.service;

import com.example.springclase4.practicaintegradoratm.model.Url;
import com.example.springclase4.practicaintegradoratm.repository.DTO.UrlDTO;
import com.example.springclase4.practicaintegradoratm.repository.DTO.UrlRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements IUrlService{
    @Override
    public String saveUrl(UrlRequestDTO link) {
        return null;
    }

    @Override
    public UrlDTO getRedirected(String linkId) {
        return null;
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
