package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListPromosDTO {
    private int userId;
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PostPromoDTO> posts;
}
