package com.linktracker.demo.repositories;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.models.Link;

import java.util.ArrayList;

public interface ILinkRepository {
    Link addLink(Link link);
}
