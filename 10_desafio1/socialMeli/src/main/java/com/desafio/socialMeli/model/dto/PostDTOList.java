package com.desafio.socialMeli.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostDTOList {

    private List<PostDTO> postDTOList;

    public PostDTOList() {
        this.postDTOList = new ArrayList<PostDTO>();
    }
}
