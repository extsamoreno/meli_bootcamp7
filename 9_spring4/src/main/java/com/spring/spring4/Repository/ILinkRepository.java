package com.spring.spring4.Repository;

import com.spring.spring4.Classes.Link;

import java.util.List;

public interface ILinkRepository {
    public Link saveLink(String name, String password);
    List<Link> getLinks();
}
