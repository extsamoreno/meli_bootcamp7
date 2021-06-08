package com.meli.spring_challenge.service.dto;

import com.meli.spring_challenge.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostDto{
    private int id_post;
    private Date date;
}
