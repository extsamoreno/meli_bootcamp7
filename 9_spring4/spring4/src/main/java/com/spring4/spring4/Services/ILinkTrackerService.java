package com.spring4.spring4.Services;

import com.spring4.spring4.DTOs.LinkMetricDTO;
import com.spring4.spring4.DTOs.LinkRequestDTO;
import com.spring4.spring4.DTOs.LinkResponseDTO;
import com.spring4.spring4.Exceptions.InvalidLinkPassException;
import com.spring4.spring4.Exceptions.LinkInactiveException;
import com.spring4.spring4.Exceptions.LinkNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ILinkTrackerService {
    LinkResponseDTO create(LinkRequestDTO linkDTOreq);
    void redirect(HttpServletResponse response, int id, String pass) throws IOException, LinkNotFoundException, LinkInactiveException, InvalidLinkPassException;
    LinkMetricDTO getMetricByLink(int id, String pass) throws LinkNotFoundException, InvalidLinkPassException;
    void invalidate(int id, String pass) throws LinkNotFoundException, InvalidLinkPassException;
}
