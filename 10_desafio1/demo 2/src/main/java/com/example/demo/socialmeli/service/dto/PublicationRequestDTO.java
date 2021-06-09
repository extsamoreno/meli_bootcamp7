package com.example.demo.socialmeli.service.dto;

import com.example.demo.socialmeli.repository.Publication;
import lombok.Data;

@Data
public class PublicationRequestDTO extends Publication {
    private int userId;
}
