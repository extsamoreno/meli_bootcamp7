package com.ejercitacion.ejercitacion.entity;

public class StoredLink {

    private Integer id;
    private String url;
    private Integer redirectionsCounter;
    private Boolean valid;
    private String password;

    public StoredLink(Integer id, String url, Integer redirectionsCounter, Boolean valid, String password) {
        this.id = id;
        this.url = url;
        this.redirectionsCounter = redirectionsCounter;
        this.valid = valid;
        this.password = password;
    }

    public StoredLink() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRedirectionsCounter() {
        return redirectionsCounter;
    }

    public void setRedirectionsCounter(Integer redirectionsCounter) {
        this.redirectionsCounter = redirectionsCounter;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
