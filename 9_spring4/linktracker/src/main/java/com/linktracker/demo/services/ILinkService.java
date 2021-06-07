package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkReportDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;

public interface ILinkService {
    LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkURLNotValidException, LinkAlreadyExistException;
    String getLink(int linkID, String pass) throws LinkIDNotValidException, PasswordAuthenticationFailedException;
    LinkReportDTO getLinkReport(int linkID) throws  LinkIDNotValidException;
    String invalidateLink(int linkID) throws ResponseException;
}
