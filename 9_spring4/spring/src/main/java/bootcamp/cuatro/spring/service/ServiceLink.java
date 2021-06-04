package bootcamp.cuatro.spring.service;

import bootcamp.cuatro.spring.model.Link;
import bootcamp.cuatro.spring.repository.ILinkRepository;
import bootcamp.cuatro.spring.service.dto.LinkDto;
import bootcamp.cuatro.spring.service.dto.ResponseLinkDTO;
import bootcamp.cuatro.spring.service.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;


@Service
public class ServiceLink implements  IServiceLink{

    @Autowired
    ILinkRepository iLinkRepository;


    @Override
    public ResponseLinkDTO createLink(LinkDto link) {
        Link parseLink= LinkMapper.toLink(link);
        parseLink.setActive(true);
        Link result=iLinkRepository.save(parseLink);
        return new ResponseLinkDTO(result.getId());
    }

    @Override
    public RedirectView redirectByLinkId(Integer id) {

        RedirectView redirectView = new RedirectView();
        Link response= iLinkRepository.findById(id);
        if(response==null){
            //TODO exception
            return null;
        }
        redirectView.setUrl(response.getUrl());
        System.out.println(redirectView);
        return redirectView;
    }
}
