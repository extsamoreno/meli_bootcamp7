package com.example.demo.Repository;

import com.example.demo.Exception.DuplicatedLinkException;
import com.example.demo.Exception.InvaidLinkException;
import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.Link;

public interface ILinkRepository {

    boolean checkduplicated(String getlink);

    void addLink(Link link) throws DuplicatedLinkException;

    int getArraySize();

    Link getLinkByID(int id) throws LinkIdNotFoundException, InvaidLinkException;
}
