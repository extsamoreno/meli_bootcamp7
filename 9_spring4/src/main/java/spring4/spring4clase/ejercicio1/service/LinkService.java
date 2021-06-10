package spring4.spring4clase.ejercicio1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import spring4.spring4clase.ejercicio1.domain.Link;
import spring4.spring4clase.ejercicio1.repository.ILinkRepository;
import spring4.spring4clase.ejercicio1.response.LinkResponse;
import spring4.spring4clase.ejercicio1.service.dto.LinkDTO;

import java.util.List;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository iLinkRepository;
    int countID = 0;
    @Override
    public LinkResponse crearLink(LinkDTO linkDTO, String password) {
        countID++;
        System.out.println(countID);
        iLinkRepository.saveLink(LinkMap.toModel(linkDTO, countID,password));
        return new LinkResponse(countID,linkDTO.getLink());

    }

    @Override
    public List<Link> getLinkList() {
        return iLinkRepository.showLink();
    }

    @Override
    public Link getLinkById(int id) {
        Link respuesta = new Link();
        List<Link> listalinks = iLinkRepository.showLink();

        for(Link link:iLinkRepository.showLink()){

            if(id == link.getLinkid()) {
                respuesta = link;
                break;
            }
        }
        return respuesta;
    }

    @Override
    public RedirectView redirect(int id){
        Link link = getLinkById(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(link.getLink());
        return redirectView;

    }

    @Override
    public void setView(int linkid) {
        Link link = getLinkById(linkid);
        int view = link.getViews() +1;

        iLinkRepository.setView(link,view);
    }

    @Override
    public int getView(int linkid) {
        return iLinkRepository.getView(linkid);
    }
}