package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class PostCollectionDTO {

    private int userId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String userName;

    private List<PostDTO> posts;

}
