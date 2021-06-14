package com.example.demo.repository;

import com.example.demo.repository.entities.Url;
import com.example.demo.service.dto.UrlDTO;
import com.example.demo.service.mapper.UrlMapper;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;


@Repository
public class UrlRepository implements IUrlRepository {

    //Crud en un un map, solamente los datos y variables, no la instancia de un dto puntual, tiene que quedar lo mas encapsulado posible

    private HashMap<Integer, UrlDTO> map;

    @Override
    public Map<Integer, UrlDTO> openOrCreateLinkTackerRepository() {
        if(this.map == null)
            this.map =  new HashMap<>() {};
        return this.map;
    }

    @Override
    public UrlDTO getItemLinkTrackerRepositoryById(Integer i) {
        if(this.map.containsKey(i)) return this.map.get(i);
        return null;
    }

    //Queda por implementar el delete

    @Override
    public Integer updateLinkTrackerRepository(Url url) {
        Integer size = this.map.size()+1;
        this.map.put(size, UrlMapper.toDTO(size,url, url.getPass()));
        return size;
    }

    @Override
    public boolean updateLinkDTOCount(Integer i){
        boolean res = false;
        if(this.map.get(i) != null) {
            Integer redirections = this.map.get(i).getRedirections();
            this.map.get(i).setRedirections(redirections + 1);
            res = true;
        }
        return res;
    }

    @Override
    public boolean invalidateLinkTrackerRepository(Integer i){
        boolean res = false;
        if(this.map.get(i) != null) {
            this.map.get(i).setState(false);
            res = true;
        }
        return res;
    }

}