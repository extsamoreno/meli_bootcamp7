package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkReportDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkIDNotValidException;
import com.linktracker.demo.exceptions.LinkURLNotValidException;
import com.linktracker.demo.exceptions.ResponseException;

public interface ILinkService {
    LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkURLNotValidException, LinkAlreadyExistException;
    String getLink(int linkID) throws LinkIDNotValidException;
    LinkReportDTO getLinkReport(int linkID) throws  LinkIDNotValidException;
    String invalidateLink(int linkID) throws ResponseException;
}
