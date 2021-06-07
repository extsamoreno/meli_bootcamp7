package com.api.apiMask.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Link implements Cloneable{
    String url, password;
    Long linkId;
    boolean valid;
    int count;

    public Link(String url, String password){
        this.url = url;
        this.password = password;
        this.valid = true;
    }

    public void setAll(Link link) {
        this.url = link.getUrl();
        this.password = link.getPassword();
        this.linkId = link.getLinkId();
        this.valid = link.isValid();
        this.count = link.getCount();
    }
}
