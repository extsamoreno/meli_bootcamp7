package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCountResponse {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;
    @JsonProperty("promo_products_count")
    private Integer promoProductsCount;

    public ProductCountResponse(Integer userId, String username, Integer promoProductsCount) {
        this.userId = userId;
        this.username = username;
        this.promoProductsCount = promoProductsCount;
    }

    public ProductCountResponse() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPromoProductsCount() {
        return promoProductsCount;
    }

    public void setPromoProductsCount(Integer promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
    }
}

