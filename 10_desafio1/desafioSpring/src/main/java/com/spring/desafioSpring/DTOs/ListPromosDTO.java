package com.spring.desafioSpring.DTOs;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListPromosDTO {
    private Integer userId;
    private String userName;
    List<PostWithoutIdUserDTO> posts;
}
