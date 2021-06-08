package com.meli.linkTracker.mapper;

import com.meli.linkTracker.dto.UrlDto;
import com.meli.linkTracker.dto.UrlInputDto;
import com.meli.linkTracker.model.Url;

public class UrlMapper {
    public static Url DtoToUrl(UrlDto urlDto){
        return  new Url("-1", urlDto.getUrl(),0,true,"");
    }

    public static Url InputDtoToUrl(UrlInputDto urlDto){
        return  new Url("-1", urlDto.getUrl(),0,true,urlDto.getPassword());
    }

    public static UrlDto UrlToDto(Url url){
        return  new UrlDto(url.getUrl(),0);
    }
}
