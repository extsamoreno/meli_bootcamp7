package com.example.challenge.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponsePromotionListDTO {
   private int userId;
   private String userName;
   private List<PostPromotionDTO> posts;

}
