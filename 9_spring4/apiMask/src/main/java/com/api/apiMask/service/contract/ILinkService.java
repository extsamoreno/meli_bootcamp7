package com.api.apiMask.service.contract;

import com.api.apiMask.controller.dto.request.UrlDTO;
import com.api.apiMask.controller.dto.response.LinkDTO;
import com.api.apiMask.exception.LinkDontExistException;
import com.api.apiMask.exception.LinkValidationException;
import com.api.apiMask.exception.URLAlreadyUsedException;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkService {
    LinkDTO createLink(UrlDTO urlDTO) throws URLAlreadyUsedException;

    RedirectView redirect(long linkId, String password) throws LinkValidationException;

    Integer getRedirectCount(long linkId) throws LinkDontExistException;

    LinkDTO invalidateLink(long linkId) throws LinkDontExistException;
}
