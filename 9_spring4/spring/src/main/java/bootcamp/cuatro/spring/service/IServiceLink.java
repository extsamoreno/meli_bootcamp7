package bootcamp.cuatro.spring.service;

import bootcamp.cuatro.spring.exception.LInkUnavailableException;
import bootcamp.cuatro.spring.exception.LinkMalformedSyntaxException;
import bootcamp.cuatro.spring.exception.LinkNotFoundException;
import bootcamp.cuatro.spring.service.dto.LinkDto;
import bootcamp.cuatro.spring.service.dto.ResponseLinkDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

public interface IServiceLink {

    ResponseLinkDTO createLink(LinkDto link);

    RedirectView redirectByLinkId(Integer id) throws LinkNotFoundException, LinkMalformedSyntaxException, LInkUnavailableException;

    ResponseLinkDTO inactivateLink(Integer id) throws LinkNotFoundException, LInkUnavailableException;

    ResponseLinkDTO getStadistics(Integer id) throws LinkNotFoundException, LInkUnavailableException;

    ResponseLinkDTO addPassword(Integer id, LinkDto link) throws LinkNotFoundException, LInkUnavailableException;
}
