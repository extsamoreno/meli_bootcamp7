package com.company;

// Esta interfaz va a poder comprar distinto tipo de datos
public interface Precedable <T> {
    public int precedeA(T t); // le pasamos el tipo de dato
}