package com.example.LinkTracker.repository;

import com.example.LinkTracker.model.Url;
import com.example.LinkTracker.service.dto.RequestUrlNewDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class Urlrepository implements IUrlrepository {

    private ArrayList<Url> linkList = new ArrayList<>();
    private Integer count = 1;

    @Override
    public Url createUrl(RequestUrlNewDTO requestUrlNewDTO) {
        Url urlnew = new Url(requestUrlNewDTO.getValue(), this.count,0 , requestUrlNewDTO.getPasssword(),true);
        if (this.linkList.contains(urlnew)){
            Url link = this.linkList.get(linkList.indexOf(urlnew));
            link.setKey_redirect(link.getKey_redirect()+1);
        }else{
            linkList.add(urlnew);
        }

        this.count ++;
        return urlnew;
    }
    @Override
    public String getUrl(Integer value){
        String urlReturn = "";
        for (Url url : this.linkList) {

            if (url.getId().compareTo(value)==0){
                urlReturn = url.getValue();
                url.setKey_redirect(url.getKey_redirect()+1);
                System.out.println(url.getId()+" - "+value+" - "+ url.getKey_redirect());
            }
        }
        return urlReturn;
    }
    @Override
    public Integer getMetric(Integer value){
        Integer response = 0;
        for (Url url : this.linkList) {
            if (url.getId().compareTo(value)==0){
                response = url.getKey_redirect();
                System.out.println(url.getId()+" - "+response+" - "+ url.getKey_redirect());
            }
        }
        return response;
    }

    @Override
    public boolean disableUrl(Integer value){
        Integer response = 0;
        for (Url url : this.linkList) {
            if (url.getId().compareTo(value)==0){
                url.setAvailable(false);
                System.out.println(url.getId()+" - "+response+" - "+ url.isAvailable());
            }
        }
        return true;
    }

}
