package com.example.demo.Repository;

import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.Link;

public interface ILinkRepository {

    void addLink(Link link);

    int getArraySize();

    Link getLinkByID(int id) throws LinkIdNotFoundException;
}
