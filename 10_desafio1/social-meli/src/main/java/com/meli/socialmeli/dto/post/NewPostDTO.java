package com.meli.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPostDTO {
    private Integer userId;
    private Integer postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private Integer category;
    private double price;
}
