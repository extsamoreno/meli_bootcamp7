package com.example.demo.socialmeli.service.dto;

import com.example.demo.socialmeli.repository.Publication;
import lombok.Data;

import java.util.ArrayList;
@Data
public class PublicationListDTO {
    private int userId;
    private ArrayList<Publication> posts;
}
