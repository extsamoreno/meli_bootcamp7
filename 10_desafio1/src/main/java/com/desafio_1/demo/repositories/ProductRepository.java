package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.ProductDetail;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{

    private ArrayList<Product> listProducts = new ArrayList<>();

    @Override
    public void addProduct(Product product) throws UnhandledException {

        try{
            int id = listProducts.size()+1;
            ProductDetail detail = product.getDetail();
            product.setIdPost(id);
            product.setDetail(new ProductDetail(id, detail.getProductName(),detail.getType(), detail.getBrand(), detail.getColor(),detail.getNotes()));
            listProducts.add(product);

        }catch(Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }

    @Override
    public ArrayList<Product> findProductsByFollowedId(List<Integer> followedIds, Comparator<LocalDate> c) throws UnhandledException {
        try{

            ArrayList<Product> products = new ArrayList<>();

            List<Product> productsFind = listProducts.stream()
                    .filter(p -> followedIds.contains(p.getUserId()) && p.getDate().isAfter(LocalDate.now().minusDays(14)))
                    .sorted((a, b) -> c.compare(a.getDate(), b.getDate()))
                    .collect(Collectors.toList());

            products.addAll(productsFind);

            return products;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Product> findProductsPromoByUserId(int userId, Comparator<LocalDate> c) throws UnhandledException {
        try{
            ArrayList<Product> products = new ArrayList<>();

            List<Product> productsFind = listProducts.stream()
                    .filter(p -> p.getUserId() == userId && p.isHasPromo())
                    .sorted((a, b) -> c.compare(a.getDate(), b.getDate()))
                    .collect(Collectors.toList());

            products.addAll(productsFind);

            return products;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }
    }
}