package com.example.linktracker.dtos;

public class LinkDTO {
    private int linkId;
    private String link;

    public LinkDTO() {
    }

    public LinkDTO(int linkId, String link) {
        this.linkId = linkId;
        this.link = link;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
