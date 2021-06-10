package com.desafio.socialMeli.service;

import com.desafio.socialMeli.service.dto.PostDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface IOrderService {

    List <PostDTO> orderPostByDate(List<PostDTO> postDTOS, String order);

/*    <T> ArrayList<T> orderDecByDate(ArrayList <T> t);
    <T> ArrayList<T> orderAscByName(ArrayList <T> t);
    <T> ArrayList<T> orderDecByName(ArrayList <T> t);
*/
}

