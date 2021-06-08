package com.api.linktracker.repository;

import com.api.linktracker.exception.IncorrectIdException;
import com.api.linktracker.models.Link;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class LinkRepositoryImpl implements ILinkRepository {

    private static Map<Integer, Link> database = new HashMap<>();

    static {
        database.put(0, new Link("http://www.google.com", "1234", true, 0));
        database.put(1, new Link("http://www.youtube.com", "1234", true, 0));
        database.put(2, new Link("http://www.facebook.com", "1234", true, 0));
        database.put(3, new Link("http://www.mercadolibre.com", "1234", true, 0));
        database.put(4, new Link("http://www.mercadopago.com", "1234", true, 0));
    }

    static int counter = 4;

    @Override
    public int createLink(String link, String password) {
        counter++;
        int linkId = counter;
        database.put(linkId, new Link(link, password, true, 0));
        return linkId;
    }

    @Override
    public int createLink(String url) {
        counter++;
        int linkId = counter;
        database.put(linkId, new Link(url, true));
        return linkId;
    }

    public void setLinkValidation(int linkId, boolean isValid) {
        database.get(linkId).setValid(isValid);
    }

    @Override
    public boolean isLinkIdValid(int linkId) {
        return database.get(linkId).isValid();
    }

    @Override
    public boolean linkIdExists(int linkId) {
        return database.containsKey(linkId);
    }

    @Override
    public String getLinkURLById(int linkId) {
        return database.get(linkId).getUrl();
    }

    @Override
    public String getPasswordById(int linkId) {
        return database.get(linkId).getPassword();
    }

    @Override
    public int getRedirectionCounterById(int linkId) {
        return database.get(linkId).getRedirectionCounter();
    }

    @Override
    public void increaseRedirectionCounter(int linkId) {
        Link link = database.get(linkId);
        int redirectionCounter = database.get(linkId).getRedirectionCounter();
        link.setRedirectionCounter(redirectionCounter + 1);
    }
}
