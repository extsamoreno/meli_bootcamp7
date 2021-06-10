package com.socialmeli.socialmeli.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductUserPromoDTO {
    int userId;
    String userName;
    int promoproducts_count;
}
