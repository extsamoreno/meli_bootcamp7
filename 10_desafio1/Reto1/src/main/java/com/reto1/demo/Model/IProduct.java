package com.reto1.demo.Model;

public interface IProduct {
    default double desc(double price) {
        return price;
    }
}
