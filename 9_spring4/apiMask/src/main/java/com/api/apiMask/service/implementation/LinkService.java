package com.api.apiMask.service.implementation;

import com.api.apiMask.controller.dto.request.UrlDTO;
import com.api.apiMask.controller.dto.response.LinkDTO;
import com.api.apiMask.exception.*;
import com.api.apiMask.repository.contract.ILinkRepository;
import com.api.apiMask.service.contract.ILinkService;
import com.api.apiMask.service.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository iLinkRepository;

    @Override
    public LinkDTO createLink(UrlDTO urlDTO) throws URLAlreadyUsedException {
        var newLink = iLinkRepository.createLink(urlDTO.getUrl(), urlDTO.getPassword());
        return LinkMapper.toDTO(newLink);
    }

    @Override
    public RedirectView redirect(long linkId, String password) throws LinkValidationException {
        var link = iLinkRepository.getByLinkId(linkId);
        if (link.getPassword() != null && !link.getPassword().equals(password))
            throw new PasswordNotCorrectException();

        if (!link.isValid())
            throw new LinkIsNotValid(linkId);

        link.setCount(link.getCount()+1);
        iLinkRepository.save(link);

        return new RedirectView(link.getUrl().contains("http://") ? link.getUrl() : "http://"+link.getUrl(), false);
    }

    @Override
    public Integer getRedirectCount(long linkId) throws LinkDontExistException  {
        var link = iLinkRepository.getByLinkId(linkId);
        return link.getCount();
    }

    @Override
    public LinkDTO invalidateLink(long linkId) throws LinkDontExistException {
        var link = iLinkRepository.getByLinkId(linkId);
        link.setValid(false);
        iLinkRepository.save(link);

        return LinkMapper.toDTO(link);
    }
}
