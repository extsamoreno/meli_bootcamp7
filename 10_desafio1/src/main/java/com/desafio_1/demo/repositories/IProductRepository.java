package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface IProductRepository {
    Product addProduct(Product product) throws UnhandledException;
    ArrayList<Product> findProductsByFollowedId(List<Integer> followedIds, Comparator<LocalDate> c) throws UnhandledException;
}
