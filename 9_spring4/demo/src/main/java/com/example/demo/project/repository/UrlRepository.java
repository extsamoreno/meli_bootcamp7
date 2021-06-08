package com.example.demo.project.repository;

import com.example.demo.project.exception.UrlIdNotFoundException;
import com.example.demo.project.models.Url;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UrlRepository implements IUrlRepository {

    private List<Url> urls = new ArrayList<>();

    @Override
    public Url getById(Integer id) throws UrlIdNotFoundException {
        if (urls.size() > id) return urls.get(id);
        else throw new UrlIdNotFoundException(id);
    }

    @Override
    public Integer addUrl(Url url) {
        //Tendria que verificar que no este ya insertada
        if (urls.add(url)) {
            return urls.size() - 1;
        } else {
            return -1;
        }
    }
}
