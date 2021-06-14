package com.desafio.socialMeli.model.service;

import com.desafio.socialMeli.model.dao.models.User;
import com.desafio.socialMeli.model.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
class OrderService implements IOrderService {

    @Override
    public List<PostDTO> orderDTOByDate(List<PostDTO> postDTOS, String order) {

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

    @Override
    public List<User> orderUserByName(List<User> userList, String order){
        userList.sort(Comparator.comparing(f -> f.getName()));
        if(order.equals("name_asc")) Collections.reverse(userList);
        return userList;
    }
}
