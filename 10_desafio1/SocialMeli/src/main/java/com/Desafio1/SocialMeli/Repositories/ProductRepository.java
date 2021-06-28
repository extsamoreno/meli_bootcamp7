package com.Desafio1.SocialMeli.Repositories;

import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository implements IProductRepository{
    private AtomicInteger index; //Atributo para crear un id unico para cada producto
    private List<Product> productList;

    public ProductRepository(){
        this.productList = new ArrayList<>();
        this.index = new AtomicInteger(0); // Inicializa el atributo en 0
    }

    @Override
    public void addProduct(Product product)throws DuplicateIdException{
        //Verifico que no exista un producto con el mismo numero de id
        if(this.productList.stream().anyMatch(prod->prod.getProductId() == product.getProductId())){
            throw new DuplicateIdException("Ya existe un producto con el id " + product.getProductId() + ".");
        }
        //Aumento el id en 1 antes de agregar el post a la lista
        int id = index.incrementAndGet();
        product.setProductId(id);
        productList.add(product);
    }
}
