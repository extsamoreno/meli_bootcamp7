package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.Utils.Constant;
import com.example.MeliSocialApi.project.exception.ProductNoPromoException;
import com.example.MeliSocialApi.project.exception.ProductNoValidDateException;
import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.model.Product;
import com.example.MeliSocialApi.project.model.ProductDetails;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.repository.IProductRepository;
import com.example.MeliSocialApi.project.service.dto.*;
import com.example.MeliSocialApi.project.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IUserService userService;
    public void createProductPromo(ProductDTO productParam) throws UserNotFoundException, ProductNoValidDateException, ProductNoPromoException {
        if (!productParam.getHasPromo())
            throw new ProductNoPromoException();
        createProduct(productParam);
    }
    public void createProduct(ProductDTO productParam) throws UserNotFoundException, ProductNoValidDateException {
        if (productParam.getDate().after(Date.valueOf(LocalDate.now())))
            throw new ProductNoValidDateException();
        ProductDetailDTO categoryParam = productParam.getDetail();
        User user = userService.getUser(productParam.getUserId());
        Product product = productRepository.getProducts().get(productParam.getIdPost());
        if (product == null && categoryParam != null) {
            ProductDetails details = productRepository.getDetails().get(categoryParam.getProductId());
            if (details == null) {
                details = ProductMapper.productDetailsDTOToDetails(categoryParam);
                 productRepository.getDetails().put(categoryParam.getProductId(), details);
            }
            product = productRepository.getProducts().put(productParam.getIdPost(), ProductMapper.productDetailsDTOToDetails(productParam, details));
        }
    }

    public ProductUserDTOResponse getProductFromUser(Integer userId, int weeks, Optional<String> order) throws UserNotFoundException {
        User user = userService.getUser(userId);
        Map<Integer, Product> products = productRepository.getProducts();
        List<ProductDTO> productsOrganized = new LinkedList<>();
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getUserId().equals(userId)) {
                if (product.getValue().getDate().after(Date.valueOf(LocalDate.now().minusWeeks(weeks)))) {
                    productsOrganized.add(ProductMapper.productToProductDTO(product.getValue(),ProductMapper.productDetailsToDTO(product.getValue().getDetail())));
                }
            }
        }
        orderByDate(productsOrganized,order);
        return ProductMapper.productUserToDTO(user, productsOrganized);
    }
    private void orderByDate(List<ProductDTO> productsOrganized, Optional<String> order){
        Comparator<ProductDTO> productDateComparator = Comparator.comparing(ProductDTO::getDate).reversed();
        Optional<Optional<String>> orderNoNullable = Optional.ofNullable(order).filter(s -> !s.isEmpty());
        if(order.isPresent()) {
            switch (order.get()) {
                case Constant.OrderDateUp:
                    productsOrganized.sort(productDateComparator.reversed());
                    break;
                case Constant.OrderDateBack:
                    productsOrganized.sort(productDateComparator);
                    break;
            }
        }
    }
    public ProductPromoCountDTOResponse getCountProductsPromoByUser(Integer userId) throws UserNotFoundException {
        User user = userService.getUser(userId);
        LinkedList<Product> productsDiscount = new LinkedList<>();
        Map<Integer, Product> products = productRepository.getProducts();
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getUserId().equals(userId)) {
                if(product.getValue().getHasPromo())
                    productsDiscount.add(product.getValue());
                }
            }
        return ProductMapper.promoToProductPromoCount(user,productsDiscount.size());
    }

    public ProductUserDTOResponse getProductPromoFromUser(Integer userId) throws UserNotFoundException {
        User user = userService.getUser(userId);
        if (user == null)
            throw new UserNotFoundException(userId);
        Map<Integer, Product> products = productRepository.getProducts();
        List<ProductDTO> productsOrganized = new LinkedList<>();
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getUserId().equals(userId)) {
                if (product.getValue().getHasPromo()) {
                    productsOrganized.add(ProductMapper.productToProductDTO(product.getValue(),ProductMapper.productDetailsToDTO(product.getValue().getDetail())));
                }
            }
        }
        return ProductMapper.productUserToDTO(user, productsOrganized);
    }
}





