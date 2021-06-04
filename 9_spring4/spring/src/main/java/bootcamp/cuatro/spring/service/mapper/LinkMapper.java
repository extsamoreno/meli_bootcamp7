package bootcamp.cuatro.spring.service.mapper;

import bootcamp.cuatro.spring.model.Link;
import bootcamp.cuatro.spring.service.dto.LinkDto;

public class LinkMapper {



    public static LinkDto toDTO(Link link){
        return new LinkDto(link.getUrl(),link.getPassword());
    }

    public static Link toLink(LinkDto linkDto){
        return new Link(null,linkDto.getUrl(),linkDto.getPassword(),true);
    }

}
