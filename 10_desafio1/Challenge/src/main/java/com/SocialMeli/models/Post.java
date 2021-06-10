package com.SocialMeli.models;

import lombok.Data;
import java.time.LocalDate;


@Data
public class Post {
    int userId;
    int id_post;
    LocalDate date;
}