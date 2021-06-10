package com.socialmedia.socialmedia.repositories;

import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;

public interface IRepository<T> {
    int add(T object);
    T update(T object) throws ObjectNotFoundException;
    T getById(int id) throws ObjectNotFoundException;
    //TODO: Punto extra - delete logico - agregar campo en db y update con metodo existente.
}
