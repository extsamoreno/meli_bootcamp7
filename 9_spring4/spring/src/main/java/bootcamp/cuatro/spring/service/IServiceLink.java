package bootcamp.cuatro.spring.service;

import bootcamp.cuatro.spring.service.dto.LinkDto;
import bootcamp.cuatro.spring.service.dto.ResponseLinkDTO;
import org.springframework.web.servlet.view.RedirectView;

public interface IServiceLink {

    public ResponseLinkDTO createLink(LinkDto link);

    RedirectView redirectByLinkId(Integer id);
}
