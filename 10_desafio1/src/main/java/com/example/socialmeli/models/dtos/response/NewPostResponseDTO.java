package com.example.socialmeli.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class NewPostResponseDTO {
    private int userId;
    private int postId;
}
