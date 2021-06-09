package com.example.desafio1.repositories;

import com.example.desafio1.models.Publishing;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IProductRepository {
    void addPublishing(Publishing pub);
    List<Publishing> getPublishing(int userId, LocalDate dateFrom, LocalDate dateTo);
    List<Publishing> getPromoPublishing(int userId);
}
