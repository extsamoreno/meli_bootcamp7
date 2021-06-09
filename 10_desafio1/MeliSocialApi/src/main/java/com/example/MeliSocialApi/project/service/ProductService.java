package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.model.Product;
import com.example.MeliSocialApi.project.model.ProductDetails;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.repository.IProductRepository;
import com.example.MeliSocialApi.project.repository.IUserRepository;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.ProductDetailDTO;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductUserDTOResponse;
import com.example.MeliSocialApi.project.service.mapper.ProductMapper;
import com.example.MeliSocialApi.project.service.mapper.UserMapper;
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
    IUserRepository userRepository;

    public void createProduct(ProductDTO productParam) throws UserNotFoundException {
        ProductDetailDTO categoryParam = productParam.getDetail();
        User user = userRepository.getUser(productParam.getUserId());
        if (user == null)
            throw new UserNotFoundException(productParam.getUserId());
        Product product = productRepository.getProducts().get(productParam.getIdPost());
        if (product == null && categoryParam != null) {
            ProductDetails details = productRepository.getDetails().get(categoryParam.getProductId());
            if (details == null)
                details = productRepository.getDetails().put(categoryParam.getProductId(), ProductMapper.productDetailsDTOToDetails(categoryParam));
            product = productRepository.getProducts().put(productParam.getIdPost(), ProductMapper.productDetailsDTOToDetails(productParam, details));
        }
    }

    public ProductUserDTOResponse getProductFromUser(Integer userId, int weeks) throws UserNotFoundException {
        User user = userRepository.getUser(userId);
        if (user == null)
            throw new UserNotFoundException(userId);
        Map<Integer, Product> products = productRepository.getProducts();
        List<ProductDTO> productsOrganized = new LinkedList<>();
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getUserId().equals(userId)) {
                if (product.getValue().getDate().after(Date.valueOf(LocalDate.now().minusWeeks(weeks)))) {
                    productsOrganized.add(ProductMapper.productToProductDTO(product.getValue(),ProductMapper.productDetailsToDTO(product.getValue().getDetail())));
                }
            }
        }
        return ProductMapper.productUserToDTO(userId, getSortedByDate(productsOrganized));
    }

    public List<ProductDTO> getSortedByDate(List<ProductDTO> products){
        Comparator<ProductDTO> productDateComparator = Comparator.comparing(ProductDTO::getDate).reversed();
        products.sort(productDateComparator);
        return products;
    }
}




