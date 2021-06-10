package com.example.desafio1.service.product;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.exception.WrongProductIdException;
import com.example.desafio1.model.Product;
import com.example.desafio1.repository.IProductPostRepository;
import com.example.desafio1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProductService implements IProductService {
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
            throws ProductNotFoundException, ProductInconsistencyException,
            WrongProductIdException
    {
        int id = productRequest.getProduct_id();

        if(iProductRepository.isUsedId(id))
        {
            alreadyInCatalog(productRequest);
            /*Product catalogProduct = iProductRepository.getProductById(id);
            if (!(
                catalogProduct.getProductName().equals(productRequest.getProductName()) &&
                catalogProduct.getType().equals(productRequest.getType()) &&
                catalogProduct.getBrand().equals(productRequest.getBrand()) &&
                catalogProduct.getColor().equals(productRequest.getColor()) &&
                catalogProduct.getNotes().equals(productRequest.getNotes())
                ))
            {
                throw new ProductInconsistencyException(id, iProductRepository.validId());
            }*/

        }
        else
        {
            avoidDuplicateProduct(productRequest);
            /*if (!iProductRepository.isProductInCatalog(productRequest))
            {
                addProductToCatalog(productRequest);
            }
            else
            {
                id = iProductRepository.getProductId(productRequest);
                throw new WrongProductIdException(id);
            }*/
        }
        return iProductRepository.getProductById(id);
    }

    private void alreadyInCatalog(Product prodRequest) throws ProductInconsistencyException, ProductNotFoundException
    {
        Product catalogProduct = iProductRepository.getProductById(prodRequest.getProduct_id());
        if (!(
                catalogProduct.getProductName().equals(prodRequest.getProductName()) &&
                        catalogProduct.getType().equals(prodRequest.getType()) &&
                        catalogProduct.getBrand().equals(prodRequest.getBrand()) &&
                        catalogProduct.getColor().equals(prodRequest.getColor()) &&
                        catalogProduct.getNotes().equals(prodRequest.getNotes())
        ))
        {
            throw new ProductInconsistencyException(prodRequest.getProduct_id(), iProductRepository.validId());
        }
    }

    private void avoidDuplicateProduct(Product requestProduct) throws WrongProductIdException
    {
       if (!iProductRepository.isProductInCatalog(requestProduct))
            {
                addProductToCatalog(requestProduct);
            }
            else
            {
                int id = iProductRepository.getProductId(requestProduct);
                throw new WrongProductIdException(id);
            }
    }

    //Method for test queries only
    @Override
    public HashMap<Integer, Product> getCatalog() {
        return iProductRepository.getProductCatalog();
    }


}
