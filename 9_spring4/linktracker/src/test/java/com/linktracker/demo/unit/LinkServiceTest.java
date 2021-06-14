package com.linktracker.demo.unit;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;
import com.linktracker.demo.models.Link;
import com.linktracker.demo.repositories.LinkRepository;
import com.linktracker.demo.services.LinkService;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LinkServiceTest {

    @Mock
    private LinkRepository linkRepository;

    @InjectMocks
    private LinkService linkService;


    @Test
    public void testCreateLinkWithValidUrlAndPassword() throws LinkInvalidException, LinkAlreadyExistException, LinkPasswordInvalidException {
        //Arrange
        String urlExpected = "https://www.google.com.ar";
        String passwordExpected = "Santi12345.";
        LinkRequestDTO requestBody = new LinkRequestDTO(urlExpected, passwordExpected);

        Link requestLinkRepository = new Link(urlExpected,true, passwordExpected);
        Link linkRepositoryExpected = new Link(1, urlExpected, true);

        LinkResponseDTO linkResponseExpected  = new LinkResponseDTO(1, urlExpected, true);
        when(linkRepository.addLink(requestLinkRepository)).thenReturn(linkRepositoryExpected);

        //Act
        LinkResponseDTO linkReceived = linkService.createLink(requestBody);

        //Assert
        verify(linkRepository, atLeast(1)).addLink(requestLinkRepository);
        assertEquals(linkResponseExpected, linkReceived);

    }
    
    @Test
    public void testCreateLinkWithInvalidUrl() throws LinkInvalidException, LinkAlreadyExistException, LinkPasswordInvalidException {
        //Arrange
        String urlExpected = "www.google.com.ar";
        String passwordExpected = "Santi12345.";

        LinkRequestDTO requestBody = new LinkRequestDTO(urlExpected, passwordExpected);

        LinkInvalidException exceptionExpected = new LinkInvalidException(urlExpected);

        //Act
        ResponseException exceptionReceived = assertThrows(LinkInvalidException.class,() ->{
            linkService.createLink(requestBody);
        });

        //Assert
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
    }

    @Test
    public void testCreateLinkWithInvalidPassword() throws LinkInvalidException, LinkAlreadyExistException, LinkPasswordInvalidException {
        //Arrange
        String urlExpected = "https://www.google.com.ar";
        String passwordExpected = "Santi";

        LinkRequestDTO requestBody = new LinkRequestDTO(urlExpected, passwordExpected);

        LinkPasswordInvalidException exceptionExpected = new LinkPasswordInvalidException();

        //Act
        ResponseException exceptionReceived = assertThrows(LinkPasswordInvalidException.class,() ->{
            linkService.createLink(requestBody);
        });

        //Assert
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
    }

    @Test
    public void testCreateLinkWithLinkExist() throws LinkInvalidException, LinkAlreadyExistException, LinkPasswordInvalidException {
        //Arrange
        String urlExpected = "https://www.google.com.ar";
        String passwordExpected = "Santi12345.";

        LinkRequestDTO requestBody = new LinkRequestDTO(urlExpected, passwordExpected);

        Link linkRepositoryExpected = new Link(1, urlExpected, true);

        when(linkRepository.findLinkByUrl(requestBody.getUrl())).thenReturn(linkRepositoryExpected);

        LinkAlreadyExistException exceptionExpected = new LinkAlreadyExistException(requestBody.getUrl());

        //Act
        ResponseException exceptionReceived = assertThrows(LinkAlreadyExistException.class,() ->{
            linkService.createLink(requestBody);
        });

        //Assert
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
    }

}
