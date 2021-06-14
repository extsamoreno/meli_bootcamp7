package com.desafio.socialMeli.model.service;

import com.desafio.socialMeli.model.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
class OrderService implements IOrderService {

    @Override
    public List<PostDTO> orderPostByDate(List<PostDTO> postDTOS, String order) {

        List<PostDTO> postDTOSReturn;

        postDTOS.sort(Comparator.comparing(post -> post.stringToDate(post.getDate())));

        postDTOSReturn = postDTOS;

        if(!order.equals("date_desc"))
            Collections.reverse(postDTOSReturn);

        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostSince(List<PostDTO> postDTOS, Date date){

        return
                postDTOS.stream()
               .filter(a->a.stringToDate(a.getDate()).after(date))
               .collect(Collectors.toList());

    }
}
