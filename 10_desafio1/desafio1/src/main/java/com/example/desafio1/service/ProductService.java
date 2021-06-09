package com.example.desafio1.service;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;
import com.example.desafio1.repository.IProductPostRepository;
import com.example.desafio1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Autowired
    IProductPostRepository iProductPostRepository;

    @Override
    public void addProductToCatalog(Product product) {
        iProductRepository.createProduct(product);
    }


    @Override
    public Product checkProductConsistency(Product productRequest)
            throws ProductNotFoundException, ProductInconsistencyException
    {
        int id = productRequest.getProduct_id();
        /*
        este key existe?
            no -> crear product
            si-> corresponde al producto dado?
                    no -> Exception y devolver un id disponible.
         */
        if(iProductRepository.isUsedId(id))
        {
            Product catalogProduct = iProductRepository.getProductById(id);
            if (!(
                catalogProduct.getProductName().equals(productRequest.getProductName()) &&
                catalogProduct.getType().equals(productRequest.getType()) &&
                catalogProduct.getBrand().equals(productRequest.getBrand()) &&
                catalogProduct.getColor().equals(productRequest.getColor()) &&
                catalogProduct.getNotes().equals(productRequest.getNotes())
                ))
            {
                throw new ProductInconsistencyException(id, iProductRepository.validId());
            }
        }
        else
        {
            addProductToCatalog(productRequest);
        }
        return iProductRepository.getProductById(id);
    }

    //Method for test queries only
    @Override
    public HashMap<Integer, Product> getCatalog() {
        return iProductRepository.getProductCatalog();
    }


}
