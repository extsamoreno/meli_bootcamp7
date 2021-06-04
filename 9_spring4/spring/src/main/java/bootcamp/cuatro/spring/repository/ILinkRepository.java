package bootcamp.cuatro.spring.repository;

import bootcamp.cuatro.spring.model.Link;
import bootcamp.cuatro.spring.service.dto.LinkDto;

public interface ILinkRepository {

    Link save(Link link);

    Link findById(Integer id);
}
