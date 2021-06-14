package com.desafio.socialMeli.model.service;

import com.desafio.socialMeli.model.dto.PostDTO;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    List<PostDTO> orderPostByDate(List<PostDTO> postDTOS, String order);
    List<PostDTO> getPostSince(List<PostDTO> postDTOS, Date date);
/*    <T> ArrayList<T> orderDecByDate(ArrayList <T> t);
    <T> ArrayList<T> orderAscByName(ArrayList <T> t);
    <T> ArrayList<T> orderDecByName(ArrayList <T> t);
*/
}

