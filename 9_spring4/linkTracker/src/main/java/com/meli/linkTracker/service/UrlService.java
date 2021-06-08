package com.meli.linkTracker.service;

import com.meli.linkTracker.dto.UrlDto;
import com.meli.linkTracker.dto.UrlInputDto;
import com.meli.linkTracker.exception.InvalidFormatUrlException;
import com.meli.linkTracker.exception.InvalidIdUrlException;
import com.meli.linkTracker.exception.UrlException;
import com.meli.linkTracker.mapper.UrlMapper;
import com.meli.linkTracker.model.Url;
import com.meli.linkTracker.repository.IUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlService implements IUrlService{

    @Autowired
    IUrlRepository iUrlRepository;

    @Override
    public String addUrl(UrlInputDto newUrl) throws InvalidFormatUrlException {
        String id="";
        if(validateUrl(newUrl.getUrl())){
            id=iUrlRepository.addUrl(newUrl);
        }else {
            throw new InvalidFormatUrlException();
        }
        return id;
    }

    @Override
    public RedirectView redirect(String linkId, String password) throws UrlException {
        ArrayList<Url> urlList = iUrlRepository.getUrlList();
        int index=getUrlById(linkId,urlList);
        Url redirect=urlList.get(index);
        isActive(redirect);
        redirect.setVisits(redirect.getVisits()+1);
        iUrlRepository.update(redirect,index);
        if(validateConection(redirect.getUrl())){
            return new RedirectView(redirect.getUrl());
        }else throw new UrlException("404");
    }

    @Override
    public UrlDto metrics(String linkId) throws UrlException {
        ArrayList<Url> urlList = iUrlRepository.getUrlList();
        Url url = urlList.get(getUrlById(linkId, urlList));
        isActive(url);
        return UrlMapper.UrlToDto(url);
    }

    @Override
    public void disable(String linkId) throws UrlException {
        ArrayList<Url> urlList = iUrlRepository.getUrlList();
        int index = getUrlById(linkId, urlList);
        Url url = urlList.get(index);
        isActive(url);
        url.setActive(false);
        iUrlRepository.update(url,index);
    }

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

    private int getUrlById(String linkId, ArrayList<Url> urlList) throws InvalidIdUrlException {
        Url redirect;
        int count=0;
        do {
            if(count>=urlList.size()) throw new InvalidIdUrlException();
            redirect=urlList.get(count);
            count++;
        }while (!redirect.getId().equals(linkId));
        return count-1;
    }

    private boolean validateConection(String url){
        boolean ret=false;
        try {
            URL con = new URL(url);
            HttpURLConnection huc = (HttpURLConnection)con.openConnection();
            int response = huc.getResponseCode();
            ret=(response>=200&&response<300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    private void isActive(Url url) throws UrlException {
        if(!url.isActive()){
            throw new UrlException("The url is no longer valid");
        }
    }

    private void checkPassword(Url url, String password) throws UrlException {
        if(!url.getPassword().equals(password)) throw new UrlException("Incorrect password");
    }
}
