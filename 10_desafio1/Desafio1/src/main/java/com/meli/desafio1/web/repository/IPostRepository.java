package com.meli.desafio1.web.repository;

import com.meli.desafio1.web.model.Npost;

import java.util.List;

public interface IPostRepository {
    public List<Npost> getListaPosts();
    public void setListaPosts(Npost npost);

}
