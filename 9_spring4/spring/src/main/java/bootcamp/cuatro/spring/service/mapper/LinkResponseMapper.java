package bootcamp.cuatro.spring.service.mapper;

import bootcamp.cuatro.spring.model.Link;
import bootcamp.cuatro.spring.service.dto.LinkDto;
import bootcamp.cuatro.spring.service.dto.ResponseLinkDTO;

public class LinkResponseMapper {

    public static ResponseLinkDTO toDTO(Link link){
        return new ResponseLinkDTO(link.getId(),link.getUrl(),link.isActive(),link.getConsultTimes(), (link.getPassword()==null ? null: "*".repeat(15)));
    }

    public static Link toLink(ResponseLinkDTO linkDto){
        return new Link(linkDto.getLinkId(),linkDto.getUrl(), linkDto.getPassword(), linkDto.getActive(), linkDto.getConsultTimes());
    }
}
