package com.SocialMeli.dtos;

public class ProductsDTO {
    private String productName;
    private String brand;
    private String type;
    private String color;
    private String notes;
    private int category;
    private double price;
    private int userId;
    private int id_post;
    private int product_id;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//Color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
//UserId
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
// id post
    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }
    // product_id;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getVCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
