package com.meli.desafio.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class URLBuilder {

    public static String buildURL(final String entity, final Integer id, String filter){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{entity}/{id}/{filter}")
                .buildAndExpand(entity, id, filter)
                .toUriString();
    }
}

