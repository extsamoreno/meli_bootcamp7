package com.example.desafio1.service;

import com.example.desafio1.model.Precedeable;

import java.util.Comparator;

public interface Sorter<T> {
    public <T> void sort(Precedeable<T>[] arr, Comparator<T> comparator);
}
