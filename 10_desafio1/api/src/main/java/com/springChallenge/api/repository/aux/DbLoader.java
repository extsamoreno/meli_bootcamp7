package com.springChallenge.api.repository.aux;

import com.springChallenge.api.repository.entity.Product;
import com.springChallenge.api.repository.entity.User;

public class DbLoader {
    public static User[] loadUsers(){
        return new User[]{
                new User(1, "user1"),
                new User(2, "user2"),
                new User(3, "user3"),
                new User(4, "user4"),
                new User(5, "user5"),
                new User(6, "seller1"),
                new User(7, "seller2"),
                new User(8, "seller3"),
                new User(9, "seller4"),
                new User(10, "seller5")
        };
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
