package com.ejercitacion.ejercitacion.dto;

public class LinkRedirectionStadisticsResponse {

    private String url;
    private Integer redirections;

    public LinkRedirectionStadisticsResponse(String url, Integer redirections) {
        this.url = url;
        this.redirections = redirections;
    }

    public LinkRedirectionStadisticsResponse() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRedirections() {
        return redirections;
    }

    public void setRedirections(Integer redirections) {
        this.redirections = redirections;
    }
}
