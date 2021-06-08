package com.example.linktracker.service;

import com.example.linktracker.exception.LinkIncorrectPasswordException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.exception.LinkUnavailableException;
import com.example.linktracker.service.dto.LinkDTO;
import com.example.linktracker.service.dto.ResponseLinkDTO;

public interface iServiceLink {

    ResponseLinkDTO createLink(LinkDTO link);
    String redirectByLinkID(Integer linkID, String password) throws LinkNotFoundException, LinkUnavailableException, LinkIncorrectPasswordException;
    ResponseLinkDTO getMetricsbyLinkID(Integer linkID) throws LinkNotFoundException;
    ResponseLinkDTO invalidateLink(Integer linkID) throws LinkNotFoundException;
}
