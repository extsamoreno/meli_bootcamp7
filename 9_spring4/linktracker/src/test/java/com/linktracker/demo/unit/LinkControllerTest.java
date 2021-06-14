package com.linktracker.demo.unit;

import com.linktracker.demo.controllers.LinkController;
import com.linktracker.demo.dtos.ErrorDTO;
import com.linktracker.demo.dtos.LinkMetricDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;
import com.linktracker.demo.models.Link;
import com.linktracker.demo.repositories.LinkRepository;
import com.linktracker.demo.services.LinkService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LinkControllerTest {

    @Mock
    private LinkService linkService;

    @InjectMocks
    private LinkController linkController;

    private LinkResponseDTO linkExpected = new LinkResponseDTO(1, "https://www.google.com.ar", true);

    @Test
    public void testCreateLinkWithValidUrl() throws LinkInvalidException, LinkAlreadyExistException, LinkPasswordInvalidException {
        //Arrange
        LinkRequestDTO requestBody = new LinkRequestDTO("https://www.google.com.ar", "Santi12345.");
        HttpStatus statusExpected = HttpStatus.CREATED;
        when(linkService.createLink(requestBody)).thenReturn(linkExpected);

        //Act
        ResponseEntity<LinkResponseDTO> response = linkController.createLink(requestBody);
        LinkResponseDTO bodyReceived = response.getBody();
        HttpStatus statusReceived = response.getStatusCode();

        //Assert
        verify(linkService, atLeast(1)).createLink(requestBody);
        assertEquals(linkExpected, bodyReceived);
        assertEquals(statusExpected, statusReceived);

    }

    @Test
    public void testRedirectByIdWithValidId() throws LinkNotFoundException, LinkInvalidPasswordOrIdException, LinkIdRequiredException, LinkInvalidException {
        //Arrange
        Integer requestId = 1;
        String requestPassword = "Santi12345.";
        when(linkService.findLinkById(requestId, requestPassword)).thenReturn(linkExpected);

        //Act
        RedirectView response = linkController.redirectById(requestId, requestPassword);

        //Assert
        verify(linkService, atLeast(1)).findLinkById(requestId, requestPassword);
        assertEquals(linkExpected.getUrl(), response.getUrl());
    }

    @Test
    public void testGetMetricsByIdWithValidId() throws LinkNotFoundException, LinkIdRequiredException {
        //Arrange
        Integer requestId = 1;
        LinkMetricDTO bodyExpected = new LinkMetricDTO(5);
        HttpStatus statusExpected = HttpStatus.OK;
        when(linkService.getMetricsById(requestId)).thenReturn(bodyExpected);

        //Act
        ResponseEntity<LinkMetricDTO> response = linkController.getMetricsById(requestId);
        LinkMetricDTO bodyReceived = response.getBody();
        HttpStatus statusReceived = response.getStatusCode();

        //Assert
        verify(linkService, atLeast(1)).getMetricsById(requestId);
        assertEquals(bodyExpected, bodyReceived);
        assertEquals(statusExpected, statusReceived);
    }

    @Test
    public void testInvalidateLinkByIdWithValidId() throws LinkNotFoundException, LinkIdRequiredException {
        //Arrange
        Integer requestId = 1;
        linkExpected.setValid(false);
        HttpStatus statusExpected = HttpStatus.OK;
        when(linkService.invalidateLinkById(requestId)).thenReturn(linkExpected);

        //Act
        ResponseEntity<LinkResponseDTO> response = linkController.invalidateLinkById(requestId);
        LinkResponseDTO bodyReceived = response.getBody();
        HttpStatus statusReceived = response.getStatusCode();

        //Assert
        verify(linkService, atLeast(1)).invalidateLinkById(requestId);
        assertEquals(linkExpected, bodyReceived);
        assertEquals(statusExpected, statusReceived);
    }
}
