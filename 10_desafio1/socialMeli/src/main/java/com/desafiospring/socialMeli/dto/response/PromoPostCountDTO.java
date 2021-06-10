package com.desafiospring.socialMeli.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PromoPostCountDTO {

    private int userId;
    private String userName;
    private int promoproducts_count;

}
