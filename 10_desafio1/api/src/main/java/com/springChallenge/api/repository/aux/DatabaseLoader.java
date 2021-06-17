package com.springChallenge.api.repository.aux;

import com.springChallenge.api.repository.entity.Product;
import com.springChallenge.api.repository.entity.User;

import java.util.ArrayList;

public class DatabaseLoader {
    public static ArrayList<User> loadUsers(){
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(1, "user1"));
        list.add(new User(2, "user2"));
        list.add(new User(3, "user3"));
        list.add(new User(4, "user4"));
        list.add(new User(5, "seller1"));
        list.add(new User(6, "seller2"));
        list.add(new User(7, "seller3"));

        return list;
    }

    public static Product[] loadProducts(){
        return new Product[]{
                new Product(1, "Auricular HyperX", "Auricular", "HyperX", "Negro", "Nuevo Auricular"),
                new Product(2, "Mouse inalámbrico", "Mouse", "Logitech", "Azul", "Nuevo mouse"),
                new Product(3, "Teclado Gamer", "Teclado", "HyperX", "Negro", "Teclado gamer espectacular"),
                new Product(4, "Monitor Gamer", "Monitor", "Samsung", "Negro", "Excelente monitor")
        };
    }
}
