package com.example.linktracker.repositories;

import com.example.linktracker.dtos.*;
import com.example.linktracker.exceptions.AlreadyExistURLException;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.InvalidURLException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TrackerRepository implements ITrackerRepository{
    private HashMap<Integer, LinkResponseDTO> linksDict = new HashMap<>();
    private Integer count = 0;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkURL, String password) throws AlreadyExistURLException {

        for (int i = 0; i < linksDict.size(); i++) {
            String url = linksDict.get(i).getUrl();

            if (alreadyExistURL(linkURL.getUrl())){
                throw new AlreadyExistURLException("The URL already exist", HttpStatus.BAD_REQUEST);
            }
        }

        LinkResponseDTO responseDTO = new LinkResponseDTO();

        responseDTO.setId(count);
        responseDTO.setUrl(linkURL.getUrl());
        responseDTO.setValid(true);
        responseDTO.setRedirects(0);
        responseDTO.setPassword(password);

        linksDict.put(count, responseDTO);
        count++;

        return responseDTO;
    }

    public boolean alreadyExistURL(String url){
        for (int i = 0; i < linksDict.size(); i++) {
            String dictURL = linksDict.get(i).getUrl();
            if (dictURL.equals(url)){
                return true;
            }
        }
        return false;
    }

    @Override
    public LinkResponseDTO invalidateLink(Integer id) throws InvalidURLException {
        for (int i = 0; i < linksDict.size(); i++) {
            Integer dictId = linksDict.get(i).getId();

            if (dictId == id){
                LinkResponseDTO linkResponseDTO = linksDict.get(i);

                linkResponseDTO.setId(linksDict.get(i).getId());
                linkResponseDTO.setPassword(linksDict.get(i).getPassword());
                linkResponseDTO.setUrl(linksDict.get(i).getUrl());
                linkResponseDTO.setRedirects(linksDict.get(i).getRedirects());
                linkResponseDTO.setValid(false);

                return linkResponseDTO;
            }
        }

        throw new InvalidURLException("the entry id not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public LinkResponseDTO getById(Integer id) {
        LinkResponseDTO linkResponseDTO = new LinkResponseDTO();

        for (int i = 0; i < linksDict.size(); i++) {
            Integer dictId = linksDict.get(i).getId();

            if (dictId == id){
                linkResponseDTO.setId(linksDict.get(i).getId());
                linkResponseDTO.setPassword(linksDict.get(i).getPassword());
                linkResponseDTO.setUrl(linksDict.get(i).getUrl());
                linkResponseDTO.setRedirects(linksDict.get(i).getRedirects());
                linkResponseDTO.setValid(linksDict.get(i).isValid());
            }
        }

        return linkResponseDTO;
    }

    @Override
    public Integer getMetric(Integer id) {
        Integer redirects = 0;

        for (int i = 0; i < linksDict.size(); i++) {
            Integer dictId = linksDict.get(i).getId();

            if (id == dictId){
                redirects = linksDict.get(i).getRedirects();
            }
        }
        return redirects;
    }

    @Override
    public String redirectById(Integer id, String password) throws InvalidURLException, InvalidPasswordException {

        for (int i = 0; i < linksDict.size(); i++) {
            Integer dictId = linksDict.get(i).getId();

            if (dictId == id){
                LinkResponseDTO linkResponseDTO = linksDict.get(i);

                if(!linkResponseDTO.getPassword().equals("") && !linkResponseDTO.getPassword().equals(password)) {
                    throw new InvalidPasswordException("The password is not correct", HttpStatus.BAD_REQUEST);
                }

                linkResponseDTO.setId(linksDict.get(i).getId());
                linkResponseDTO.setPassword(linksDict.get(i).getPassword());
                linkResponseDTO.setUrl("https://www.instagram.com/");
                linkResponseDTO.setRedirects(linksDict.get(i).getRedirects()+1);
                linkResponseDTO.setValid(linksDict.get(i).isValid());

                return linkResponseDTO.getUrl();
            }
        }

        throw new InvalidURLException("the entry id not exist", HttpStatus.BAD_REQUEST);
    }
}
