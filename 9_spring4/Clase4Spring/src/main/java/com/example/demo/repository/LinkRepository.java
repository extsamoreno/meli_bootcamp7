package com.example.demo.repository;

import com.example.demo.exceptions.LinkInvalidPasswordOrIdException;
import com.example.demo.exceptions.LinkNotFoundException;
import com.example.demo.models.Link;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository {

    Link addLink(Link link);
    Link findLinkByAddress(String address);
    Link findLinkById(int id, String password) throws LinkInvalidPasswordOrIdException;
    void addLinkCounter(int id) throws LinkNotFoundException;
    int getLinkCounter(int id) throws LinkNotFoundException;
    Link invalidateLinkByAddress(Integer id) throws LinkNotFoundException;
    Link validateLinkByAddress(Integer id) throws LinkNotFoundException;
}
