package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.model.Link;

public interface ILinkRepository {

    Link createLink(LinkRequestDTO linkRequestDTO);

    Link findById(Integer id);

    Link deleteLink(Integer id);
}
