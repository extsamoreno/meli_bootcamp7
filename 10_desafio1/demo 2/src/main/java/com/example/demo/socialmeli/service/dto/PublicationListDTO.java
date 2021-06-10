package com.example.demo.socialmeli.service.dto;

import com.example.demo.socialmeli.models.Publication;
import lombok.Data;

import java.util.ArrayList;
@Data
public class PublicationListDTO {
    private int userId;
    private ArrayList<Publication> posts;
}
