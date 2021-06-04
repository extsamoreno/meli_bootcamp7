package bootcamp.cuatro.spring.service;

import bootcamp.cuatro.spring.exception.LInkUnavailableException;
import bootcamp.cuatro.spring.exception.LinkMalformedSyntaxException;
import bootcamp.cuatro.spring.exception.LinkNotFoundException;
import bootcamp.cuatro.spring.model.Link;
import bootcamp.cuatro.spring.repository.ILinkRepository;
import bootcamp.cuatro.spring.service.dto.LinkDto;
import bootcamp.cuatro.spring.service.dto.ResponseLinkDTO;
import bootcamp.cuatro.spring.service.mapper.LinkMapper;
import bootcamp.cuatro.spring.service.mapper.LinkResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


@Service
public class ServiceLink implements  IServiceLink{

    @Autowired
    ILinkRepository iLinkRepository;


    @Override
    public ResponseLinkDTO createLink(LinkDto link) {
        Link parseLink= LinkMapper.toLink(link);
        parseLink.setActive(true);
        Link result=iLinkRepository.save(parseLink);
        return LinkResponseMapper.toDTO(result);
    }

    @Override
    public RedirectView redirectByLinkId(Integer id) throws LinkNotFoundException,LinkMalformedSyntaxException,LInkUnavailableException{
        try {
            RedirectView redirectView = new RedirectView();
            Link response= iLinkRepository.findById(id);
            new URL(response.getUrl()).toURI();
            if(response==null){
                throw new LinkNotFoundException(id);
            }if(!response.isActive()){
                throw new LInkUnavailableException(id);
            }
            redirectView.setUrl(response.getUrl());
            response.setConsultTimes(response.getConsultTimes()+1);
            iLinkRepository.save(response);

            return redirectView;
        }catch (URISyntaxException exception) {
            inactivateLink(id);
            throw new LinkMalformedSyntaxException(id);
        } catch (MalformedURLException exception) {
            inactivateLink(id);
            throw new LinkMalformedSyntaxException(id);
        }
    }

    @Override
    public ResponseLinkDTO inactivateLink(Integer id) throws LinkNotFoundException,LInkUnavailableException{
        Link response= iLinkRepository.findById(id);
        if(response==null){
            throw new LinkNotFoundException(id);
        }
        if(!response.isActive()){
            throw new LInkUnavailableException(id);
        }
        response.setActive(false);
        iLinkRepository.save(response);
        return LinkResponseMapper.toDTO(response);
    }

    @Override
    public ResponseLinkDTO getStadistics(Integer id) throws LinkNotFoundException,LInkUnavailableException{
        Link response= iLinkRepository.findById(id);
        if(response==null){
            throw new LinkNotFoundException(id);
        }
        if(!response.isActive()){
            throw new LInkUnavailableException(id);
        }
        return LinkResponseMapper.toDTO(response);
    }

    @Override
    public ResponseLinkDTO addPassword(Integer id, LinkDto link) throws LinkNotFoundException,LInkUnavailableException{
        Link response= iLinkRepository.findById(id);
        if(response==null){
            throw new LinkNotFoundException(id);
        }
        if(!response.isActive()){
            throw new LInkUnavailableException(id);
        }
        response.setPassword(link.getPassword());
        iLinkRepository.save(response);
        return LinkResponseMapper.toDTO(response);
    }


}
