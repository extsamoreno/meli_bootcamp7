package com.reto1.demo.Model.DTO.PostObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCount {
    int userId;
    String userName;
    @JsonProperty("promoproducts_count")
    int promoproductscount;

}
