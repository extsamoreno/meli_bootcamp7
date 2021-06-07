package com.spring4.linktracker.service.utils;

import com.spring4.linktracker.service.dtos.LinkDTO;

import java.util.List;

public class LinkUtils {

    public static int matchLink(List<LinkDTO> links, int id) {
        if (links != null) {
            for (LinkDTO link : links) {
                if (link.getId() == id) {
                    return id;
                }
            }
        } return -1;
    }
}
