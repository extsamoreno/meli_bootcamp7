package bootcamp.cuatro.spring.repository;

import bootcamp.cuatro.spring.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{

    HashMap<Integer, Link> links;


    public LinkRepository() {
        this.links = new HashMap<>();
    }

    @Override
    public Link save(Link link) {
        link.setId(links.size()+1);
        links.put(links.size()+1,link);
        return link;
    }

    @Override
    public Link findById(Integer id) {
        return  links.get(id);
    }


}
