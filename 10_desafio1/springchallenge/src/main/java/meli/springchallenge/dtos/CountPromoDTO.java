package meli.springchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountPromoDTO {

    private int userId;
    private String UserName;
    private int promoproducts_count;

}
