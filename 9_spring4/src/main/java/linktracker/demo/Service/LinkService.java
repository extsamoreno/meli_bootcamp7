package linktracker.demo.Service;

import linktracker.demo.Exception.*;
import linktracker.demo.Model.DTO.LinkCreateRequestDTO;
import linktracker.demo.Model.DTO.LinkCreateResponseDTO;
import linktracker.demo.Model.DTO.LinkDTO;
import linktracker.demo.Model.DTO.LinkMetricsDTO;
import linktracker.demo.Repository.IRepository;
import org.apache.commons.validator.UrlValidator;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    IRepository iRepository;

    public LinkService(IRepository iRepository) {
        this.iRepository = iRepository;
    }

    @Override
    public LinkCreateResponseDTO addLink(LinkCreateRequestDTO link) throws LinkAlreadyPresentException, InvalidURLException {
        if (!isValidUrl(link.getUrl())) {
            throw new InvalidURLException(link.getUrl());
        }
        var linkDict = iRepository.getDict();
        if (linkDict.values().stream().anyMatch(v -> v.getLink().equals(link.getUrl()))) {
            throw new LinkAlreadyPresentException(link.getUrl());
        }
        ;
        var id = linkDict.size();
        linkDict.put(id, new LinkDTO(link.getUrl(), link.getPassword()));
        return new LinkCreateResponseDTO(id);
    }

    @Override
    public String getLinkForRedirect(String id, String password) throws LinkNotFoundException, InvalidIdException, WrongPasswordException, InvalidatedLinkException {
        var linkDTO = getLinkDtoById(id);
        if (linkDTO.getPassword() != null && !linkDTO.getPassword().equals(password)){
            throw new WrongPasswordException(id);
        }
        if (linkDTO.isInvalidated()){
            throw new InvalidatedLinkException(id);
        }
        linkDTO.setNumberOfRedirects(linkDTO.getNumberOfRedirects()+1);
        return linkDTO.getLink();
    }

    @Override
    public LinkMetricsDTO getMetricsById(String id) throws InvalidIdException, LinkNotFoundException {
        var linkDTO = getLinkDtoById(id);
        return new LinkMetricsDTO(linkDTO.getNumberOfRedirects(),parseIdToInt(id));
    }

    @Override
    public String invalidateById(String id) throws InvalidIdException, LinkNotFoundException {
        var linkDTO = getLinkDtoById(id);
        linkDTO.setInvalidated(true);
        return "Invalidation of link ID:"+id+" successful";
    }

    private LinkDTO getLinkDtoById(String id) throws InvalidIdException, LinkNotFoundException {
        var linkDict = iRepository.getDict();
        var linkDTO = linkDict.get(parseIdToInt(id));
        if (linkDTO == null) {
            throw new LinkNotFoundException(id);
        }
        return linkDTO;
    }

    private int parseIdToInt(String id) throws InvalidIdException {
        try {
            return Integer.parseInt(id);
        } catch (Exception e) {
            throw new InvalidIdException(id);
        }
    }

    private boolean isValidUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }
}
