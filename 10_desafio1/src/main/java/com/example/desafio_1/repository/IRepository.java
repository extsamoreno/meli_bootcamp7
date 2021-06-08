package com.example.desafio_1.repository;

import java.util.List;

public interface IRepository<T> {
    T getById(int id);
    List<T> getAll();
    void add(T t);
}
