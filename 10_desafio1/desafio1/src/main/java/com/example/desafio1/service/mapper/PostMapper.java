package com.example.desafio1.service.mapper;

import com.example.desafio1.model.ProductPost;
import com.example.desafio1.service.dto.postdto.PostDTO;
import com.example.desafio1.service.dto.postdto.UserPostListDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PostMapper {

    public static ProductPost toProductPost(PostDTO postDTO)
    {
        Date date = toDate(postDTO.getDate());
        return new ProductPost(postDTO.getUserId(), postDTO.getId_post(), date, postDTO.getDetail(),
                postDTO.getCategory(), postDTO.getPrice());

    }

    private static Date toDate(String dateDto)
    {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(dateDto);
        }
        catch (ParseException ex){
            ex.printStackTrace();
        }
        return date;
    }

    public static UserPostListDTO toUserPostListDTO(int userId, ArrayList<ProductPost> recentPost)
    {
        return new UserPostListDTO(userId, recentPost);
    }

}
