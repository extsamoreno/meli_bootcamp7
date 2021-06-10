package com.example.demo.socialmeli.service.dto;

import com.example.demo.socialmeli.models.Publication;
import lombok.Data;

@Data
public class PublicationRequestDTO extends Publication {
    private int userId;
}
