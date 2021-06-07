package com.api.apiMask.repository.contract;

import com.api.apiMask.exception.LinkDontExistException;
import com.api.apiMask.exception.URLAlreadyUsedException;
import com.api.apiMask.repository.entity.Link;

public interface ILinkRepository{
    Link createLink(String url, String password) throws URLAlreadyUsedException;

    Link getByLinkId(long linkId) throws LinkDontExistException;

    void save(Link link) throws LinkDontExistException;
}
