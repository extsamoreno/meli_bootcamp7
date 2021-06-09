package com.meli.socialmeli.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedPublicationDTO {
    private Integer userId;
    private List<PublicationDTO> posts;
}
