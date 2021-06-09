package com.example.challenge.Services.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class ResponsePromotionListDTO {
   private int userId;
   private String userName;
   private List<PostPromotionDTO> posts;
   private int category;
   private double price;
   private boolean hasPromo;
   private double discount;

}
