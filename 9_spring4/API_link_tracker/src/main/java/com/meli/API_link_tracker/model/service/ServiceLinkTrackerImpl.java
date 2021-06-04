package com.meli.API_link_tracker.model.service;

import com.meli.API_link_tracker.model.dao.model.Link;
import com.meli.API_link_tracker.model.dao.repository.RepositoryLinkTracker;
import com.meli.API_link_tracker.model.dto.*;
import com.meli.API_link_tracker.model.exception.*;
import com.meli.API_link_tracker.model.mapper.LinkTrackerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceLinkTrackerImpl implements ServiceLinkTracker{
    @Autowired
    private RepositoryLinkTracker repositoryLinkTracker;

    public LinkRespond createLinktoDataBase(LinkRequest linkRequest, String password) throws
            FormatLinkNotValidateException, PasswordNotEnteredException, LinkAlreadyCreatedException {
        if (password.equals("")) {
            throw new PasswordNotEnteredException();
        }
        boolean linkExist = repositoryLinkTracker.verificateExistOfValue(linkRequest.getLink());
        if (linkExist) {
            throw new LinkAlreadyCreatedException(linkRequest.getLink());
        }
        validateFormat(linkRequest.getLink());
        Link newLink = LinkTrackerMapper.convertToDomain(linkRequest, password);
        int idLink = repositoryLinkTracker.addLinkToDataBase(newLink);
        return LinkTrackerMapper.convertToLinkRespond(idLink);
    }

    public String getLinkRedired(int linkId) throws LinkAlreadyInvalidatedException, IDNotFoundException {
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(linkId);
        if (link == null) {
            throw new IDNotFoundException(linkId);
        }
        if (!link.isValid()) {
            throw new LinkAlreadyInvalidatedException(linkId);
        }
        link.increaseTimesUsed();
        return link.getLink();
    }

    public int getMetricsOfLink(int linkId) throws IDNotFoundException{
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(linkId);
        if (link == null) {
            throw new IDNotFoundException(linkId);
        }
        return link.getTimeUsed();
    }

    public void invalidateLink(int linkId) throws LinkAlreadyInvalidatedException, IDNotFoundException {
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(linkId);
        if (link == null) {
            throw new IDNotFoundException(linkId);
        }
        if (!link.isValid()) {
            throw new LinkAlreadyInvalidatedException(linkId);
        }
        link.setValid(false);
    }

    private void validateFormat (String link) throws FormatLinkNotValidateException {
        Pattern pattern = Pattern.compile("https://", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(link);
        if (!matcher.find()) {
            throw new FormatLinkNotValidateException();
        }
    }
}