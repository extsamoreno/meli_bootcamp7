package com.example.spring4.models;

import com.example.spring4.dtos.LinkStringDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int linkId;
    private String linkUrl;
    private String password = "";
    private int redirectedTimes;
    private boolean isReachable = true;

    public Link(int linkId, String linkUrl) {
        this.linkId = linkId;
        this.linkUrl = linkUrl;
        this.redirectedTimes = 0;
    }

    public Link(LinkStringDTO linkStringDTO) {
        this.linkId = -1;
        this.linkUrl = linkStringDTO.getLinkUrl();
    }

    public void countRedirection() {
        this.redirectedTimes++;
    }
    public void changeStateToInvalid() {
        this.isReachable = false;
    }
}
