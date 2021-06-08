package com.example.ejerciciointegradorapi.project.services;

import com.example.ejerciciointegradorapi.project.Dao.models.LinkTracker;
import com.example.ejerciciointegradorapi.project.Dao.repositories.ILinkTrackerRepository;
import com.example.ejerciciointegradorapi.project.exceptions.InvalidUrlException;
import com.example.ejerciciointegradorapi.project.exceptions.idNotFoundException;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerMetricsDTO;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerRequestDTO;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerResponseDTO;
import com.example.ejerciciointegradorapi.project.services.mapper.LinkTrackerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.ServletResponse;

@Service
public class LinkTrackerService implements ILinkTrackerService{

    @Autowired
    ILinkTrackerRepository iLinkTrackerRepository;

    @Override
    public LinkTrackerResponseDTO createLink(LinkTrackerRequestDTO linkTrackerRequestDTO) throws InvalidUrlException {

      return LinkTrackerMapper.toDTO(iLinkTrackerRepository.saveUrl(linkTrackerRequestDTO.getUrl()));
    }

    @Override
    public LinkTrackerResponseDTO redirectUrl(Integer linkId) throws InvalidUrlException {
           return LinkTrackerMapper.toDTO(iLinkTrackerRepository.addRedirect(linkId));
    }

    @Override
    public LinkTrackerMetricsDTO getRedirectCounts(Integer linkId) throws InvalidUrlException {
      return LinkTrackerMapper.metricsToDTO(iLinkTrackerRepository.getByLinkId(linkId));
    }

    @Override
    public void invalidateLink(Integer linkId) {
        iLinkTrackerRepository.invalidateByLinkId(linkId);
    }


}
