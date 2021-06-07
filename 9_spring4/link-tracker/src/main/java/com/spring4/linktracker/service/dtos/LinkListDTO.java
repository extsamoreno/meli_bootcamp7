package com.spring4.linktracker.service.dtos;

import com.spring4.linktracker.service.mapper.LinkMapper;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor

public class LinkListDTO {
    public static List<LinkDTO> linksList;

    public static void addLink(LinkDTO linkDTO) {
        if (linksList == null) linksList = new ArrayList<LinkDTO>();
        linksList.add(linkDTO);
    }

}
