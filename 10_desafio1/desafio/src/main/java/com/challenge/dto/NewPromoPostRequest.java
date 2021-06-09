package com.challenge.dto;

import com.challenge.entity.Product;

import java.time.LocalDate;

public class NewPromoPostRequest extends NewPostRequest {

    private Boolean hasPromo;
    private Double discount;

    public NewPromoPostRequest(Integer userId, Integer postId, LocalDate date, Product detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public NewPromoPostRequest(){}

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
