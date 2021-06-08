package spring4.spring4clase.ejercicio1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring4.spring4clase.ejercicio1.domain.Link;
import spring4.spring4clase.ejercicio1.repository.ILinkRepository;
import spring4.spring4clase.ejercicio1.service.dto.LinkDTO;

@Service
public class LinkMap {
    @Autowired
    ILinkRepository iLinkRepository;

    public static Link toModel(LinkDTO linkDTO, int linkid, String password){
        return new Link(linkid,password,linkDTO.getLink(),0);
    }
}
