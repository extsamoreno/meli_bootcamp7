package spring4.spring4clase.ejercicio1.service;

import org.springframework.web.servlet.view.RedirectView;
import spring4.spring4clase.ejercicio1.domain.Link;
import spring4.spring4clase.ejercicio1.response.LinkResponse;
import spring4.spring4clase.ejercicio1.service.dto.LinkDTO;

import java.util.List;

public interface ILinkService {
    public LinkResponse crearLink(LinkDTO linkDTO, String password);
    public List<Link> getLinkList();
    public Link getLinkById(int id);
    public RedirectView redirect(int id);
    public void setView(int linkid);
    public int getView(int linkid);
}
