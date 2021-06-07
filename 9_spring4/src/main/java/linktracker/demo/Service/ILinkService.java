package linktracker.demo.Service;

import linktracker.demo.Exception.*;
import linktracker.demo.Model.DTO.LinkCreateRequestDTO;
import linktracker.demo.Model.DTO.LinkCreateResponseDTO;
import linktracker.demo.Model.DTO.LinkMetricsDTO;

public interface ILinkService {
    LinkCreateResponseDTO addLink(LinkCreateRequestDTO link) throws LinkAlreadyPresentException, InvalidURLException;
    String getLinkForRedirect(String id, String password) throws LinkNotFoundException, InvalidIdException, WrongPasswordException, InvalidatedLinkException;
    LinkMetricsDTO getMetricsById(String id) throws InvalidIdException, LinkNotFoundException;
    String invalidateById(String id) throws InvalidIdException, LinkNotFoundException;
}
