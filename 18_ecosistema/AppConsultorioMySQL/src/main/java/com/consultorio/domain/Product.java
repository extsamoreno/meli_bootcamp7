package com.consultorio.domain;

import lombok.Data;

@Data
public class Product {
  private int productId;
  private int categoryId;
  private String name;
  private double price;
  private int stock;
  private boolean active;
  private Category category;
}
