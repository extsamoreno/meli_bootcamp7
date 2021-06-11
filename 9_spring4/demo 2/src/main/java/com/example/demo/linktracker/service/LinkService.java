package com.example.demo.linktracker.service;

import com.example.demo.linktracker.service.dto.LinkDTO;
import com.example.demo.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService {
    ILinkRepository iLinkRepository;
    private static final String URL_REGEX =
            "^(https://" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public LinkService(ILinkRepository iLinkRepository) {
        this.iLinkRepository = iLinkRepository;
    }

    @Override
    public LinkDTO getCreateLink(String url) {
        LinkDTO linkIdDTO = new LinkDTO();
        url = "https://"+url;
        if (validateLink(url)) {
            int linkId = iLinkRepository.getLinkId(url);
            linkIdDTO.setUrl(url);
            linkIdDTO.setLinkId(linkId);
        }
        return linkIdDTO;
    }

    @Override
    public boolean validateLink(String url) {
        if (url == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

    @Override
    public String getUrl(int linkId) {
        String url = iLinkRepository.getLink(linkId);
        return url;
    }
}
