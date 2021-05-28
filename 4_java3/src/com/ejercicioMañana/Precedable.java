package com.ejercicioMañana;

public interface Precedable<T extends Precedable<T>> {
    public int precedeA(T t);
}
