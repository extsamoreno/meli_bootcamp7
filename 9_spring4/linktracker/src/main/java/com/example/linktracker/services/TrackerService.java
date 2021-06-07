package com.example.linktracker.services;

import com.example.linktracker.dtos.LinkResponseDTO;
import com.example.linktracker.dtos.LinkRequestDTO;
import com.example.linktracker.exceptions.AlreadyExistURLException;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.InvalidURLException;
import com.example.linktracker.repositories.ITrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class TrackerService implements ITrackerService {

    @Autowired
    private ITrackerRepository trackerRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkURL, String password) throws InvalidURLException, AlreadyExistURLException {
        if (!urlValidator(linkURL.getUrl())){
            throw new InvalidURLException("Invalid link", HttpStatus.BAD_REQUEST);
        }
        return trackerRepository.createLink(linkURL, password);
    }

    @Override
    public LinkResponseDTO getById(Integer linkId) {
        return trackerRepository.getById(linkId);
    }

    @Override
    public Integer getMetric(Integer linkId) {
        return trackerRepository.getMetric(linkId);
    }

    @Override
    public LinkResponseDTO invalidateLink(Integer linkId) throws InvalidURLException {
        return trackerRepository.invalidateLink(linkId);
    }

    @Override
    public String redirectById(Integer linkId, String password) throws InvalidURLException, InvalidPasswordException {
        return trackerRepository.redirectById(linkId, password);
    }

    public static boolean urlValidator(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (URISyntaxException exception) {
            return false;
        }

        catch (MalformedURLException exception) {
            return false;
        }
    }
}
