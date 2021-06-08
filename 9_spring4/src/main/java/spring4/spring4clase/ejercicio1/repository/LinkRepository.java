package spring4.spring4clase.ejercicio1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring4.spring4clase.ejercicio1.domain.Link;
import spring4.spring4clase.ejercicio1.service.LinkService;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{
    //Integer countLink = 0;

   // @Override
    //public Link saveLink(Link link) {

        /*HashMap<Integer , Link> dataBase;
        dataBase = dataBaseLinkTracker.dataBase;
        List<LinkDTO> responseLink = new ArrayList<>();
        countLink++;

        dataBase.put(countLink, link);
        responseLink.add(new LinkDTO(link.getLink()));

        return responseLink;*/
    //}


    @Autowired
    LinkService linkService;
    List<Link> listaLinks = new ArrayList<>();
    @Override

    public List<Link> saveLink(Link link) {

        listaLinks.add(link);
        return listaLinks;
    }

    public List<Link> showLink() {
        return listaLinks;
    }

    @Override
    public void setView(Link link, int view) {
        link.setViews(view);

    }

    @Override
    public int getView(int linkid) {
        return linkService.getLinkById(linkid).getViews();
    }
}
