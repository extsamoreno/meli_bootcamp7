package com.example.LinkTracker.service;

import com.example.LinkTracker.repository.ILinkRepository;
import com.example.LinkTracker.service.dto.LinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkDTO create(LinkDTO link) {
        LinkDTO linkDTOResult = iLinkRepository.save(link);
        return linkDTOResult;
    }

    @Override
    public LinkDTO redirect(Integer linkId) {
        Optional<LinkDTO> link = Optional.ofNullable(iLinkRepository.findByLinkId(linkId));
        link.ifPresent(this::sumMetric);
        return link.orElse(null);
    }

    @Override
    public LinkDTO redirect(Integer linkId, String password) {
        Optional<LinkDTO> link = Optional.ofNullable(iLinkRepository.findByLinkId(linkId));
        LinkDTO result = null;
        if (link.isPresent())
            result = checkLinkAndPassword(password, link.get());
        return result;
    }

    private LinkDTO checkLinkAndPassword(String password, LinkDTO linkDTO) {
        LinkDTO result = null;
        if (linkDTO.getPass() != null && linkDTO.getPass().equals(password)){
            result = linkDTO;
            sumMetric(linkDTO);
        }
        return result;
    }

    @Override
    public LinkDTO metrics(Integer linkId) {
        Optional<LinkDTO> link = Optional.ofNullable(iLinkRepository.findByLinkId(linkId));
        return link.orElse(null);
    }
    private void sumMetric(LinkDTO linkDTO) {
        linkDTO.sumCount();
        iLinkRepository.save(linkDTO);
    }
    @Override
    public void invalidate(Integer linkId) {
        Optional<LinkDTO> link = Optional.ofNullable(iLinkRepository.findByLinkId(linkId));
        link.ifPresent(iLinkRepository::delete);
    }



}
