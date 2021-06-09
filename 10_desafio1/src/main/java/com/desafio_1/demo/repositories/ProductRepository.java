package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.ProductDetail;
import com.desafio_1.demo.models.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{

    private ArrayList<Product> listProducts = new ArrayList<>();

    @Override
    public Product addProduct(Product product) throws UnhandledException {

        try{
            int id = listProducts.size()+1;
            ProductDetail detail = product.getDetail();
            product.setIdPost(id);
            product.setDetail(new ProductDetail(id, detail.getProductName(),detail.getType(), detail.getBrand(), detail.getColor(),detail.getNotes()));
            listProducts.add(product);
            return product;
        }catch(Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }

    @Override
    public ArrayList<Product> findProductsByFollowedId(List<Integer> followedIds, Comparator<LocalDate> c) throws UnhandledException {
        try{
            ArrayList<Product> products = new ArrayList<>();

            List<Product> productsFind = listProducts.stream()
                    .filter(p -> followedIds.contains(p.getUserId()))
                    .sorted((a, b) -> c.compare(a.getDate(), b.getDate()))
                    .collect(Collectors.toList());

            products.addAll(productsFind);

            return products;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }
    }
}
