package com.ejercitacion.ejercitacion.dto;

public class StoreLinkRequest {

    private String url;
    private String password;

    public StoreLinkRequest(String url, String password) {
        this.url = url;
        this.password = password;
    }

    public StoreLinkRequest() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
