package com.example.desafio1.repositories;

import com.example.desafio1.models.Publishing;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{
    List<Publishing> publishingList = new ArrayList<>();

    @Override
    public void addPublishing(Publishing pub) {
        publishingList.add(pub);
    }

    @Override
    public List<Publishing> getPublishings(int userId, LocalDate dateFrom, LocalDate dateTo) {
        return publishingList.stream()
                .filter(publishing -> publishing.getUserId() == userId)
                .filter(publishing -> publishing.getDate().isAfter(dateFrom) && publishing.getDate().isBefore(dateTo))
                .collect(Collectors.toList());
    }
}
