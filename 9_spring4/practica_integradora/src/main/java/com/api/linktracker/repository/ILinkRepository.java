package com.api.linktracker.repository;

import com.api.linktracker.exception.IncorrectIdException;

public interface ILinkRepository {

    int createLink(String url, String password);

    int createLink(String url);

    void setLinkValidation(int linkId, boolean isValid) throws IncorrectIdException;

    boolean isLinkIdValid(int linkId);

    boolean linkIdExists(int linkId);

    String getLinkURLById(int linkId);

    String getPasswordById(int linkId);

    int getRedirectionCounterById(int linkId);

    void increaseRedirectionCounter(int linkId);

}
