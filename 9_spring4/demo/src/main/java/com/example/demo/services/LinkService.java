package com.example.demo.services;

import com.example.demo.dtos.LinkDTO;
import com.example.demo.dtos.UrlDTO;
import com.example.demo.exceptions.LinkDeactivetedException;
import com.example.demo.exceptions.NotAuthorizedException;
import com.example.demo.exceptions.UrlNotValidException;
import com.example.demo.models.Link;
import com.example.demo.repositories.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public String add(UrlDTO req) throws UrlNotValidException {

        URL newUrl;

        try {
            newUrl = new URL(req.getUrl());
            if (!isValid(newUrl)){
                throw new UrlNotValidException(req.getUrl());
            }

        } catch (Exception e) {
            throw new UrlNotValidException(req.getUrl());
        }

        String CryptedPassword = "";

        if(req.getPassword().length()>1){
            Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
            CryptedPassword = pbkdf2PasswordEncoder.encode(req.getPassword());
        }


        Link newLink = new Link(0,newUrl, CryptedPassword, 0, true);
        int id = linkRepository.add(newLink);

        return "Your link was successfully added with the id: " + id;
    }

    @Override
    public RedirectView redirect(int id, String psw) throws LinkDeactivetedException, NotAuthorizedException {

        Link link = linkRepository.getLinkById(id);

        if(link.getID()<0){
            System.out.println("link = ");
            throw new LinkDeactivetedException(id);
        }

        if(link.getPassword().length()>1){

            Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
            boolean passwordIsValid = false;
            if(psw.length() > 0){
                passwordIsValid = pbkdf2PasswordEncoder.matches(psw, link.getPassword());
            }

            if(!passwordIsValid){
                throw new NotAuthorizedException("Not valid credetials", HttpStatus.FORBIDDEN);
            }
        }

        if (link.isActive()){
            linkRepository.increaseCount(id);
            System.out.println("link.getUrl().toString() = " + link.getUrl().toString());
            return new RedirectView(link.getUrl().toString());
        }
        else{
            throw new LinkDeactivetedException(id);
        }
    }

    @Override
    public LinkDTO getMetrics(int id) {

        Link link = linkRepository.getLinkById(id);
        return new LinkDTO(link.getID(), link.getUrl(), link.getCount(), link.isActive());
    }

    @Override
    public String invalidateLink(int id) {
        linkRepository.deactiveById(id);
        return "The link #" + id + " was turn to deactivated" ;
    }

    private boolean isValid(URL url) throws IOException {

        boolean result = false;

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(3000);
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        con.disconnect();

        if (status < 300){
            result = true;
        }
        return result;

    }

}
