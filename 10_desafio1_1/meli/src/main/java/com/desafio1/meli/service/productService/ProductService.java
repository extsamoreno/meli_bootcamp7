package com.desafio1.meli.service.productService;

import com.desafio1.meli.model.Publication;
import com.desafio1.meli.repository.productRepository.IProductrepository;
import com.desafio1.meli.repository.userRepository.IUserrepository;
import com.desafio1.meli.service.DTO.RequestFollowedProductList;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;
import com.desafio1.meli.service.orderType.PublicationOrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


@Service
public class ProductService implements IProductservice {

    @Autowired
    IProductrepository iProductrepository;

    @Override
    public boolean newProduct(RequestNewProduct requestNewProduct) {
        return iProductrepository.newProduct(requestNewProduct);
    }

    @Override
    public RequestFollowedProductList listProductFollowerUser(Integer user_id, PublicationOrderType order) {
        LocalDate dateFrom = LocalDate.now().minusDays(14);
        LocalDate dateBefor = LocalDate.now();
        sortByDate(iProductrepository.getProductListFollow(user_id, dateFrom, dateBefor).getPosts(), order);
        return iProductrepository.getProductListFollow(user_id, dateFrom, dateBefor);
    }

    private void sortByDate(ArrayList<Publication> posts, PublicationOrderType order) {
        if (order == null) orderListDesc(posts);
        else {
            if (order.equals(PublicationOrderType.date_desc)) orderListDesc(posts);
            if (order.equals(PublicationOrderType.date_asc)) orderListAsc(posts);
        }
    }

    private void orderListAsc(ArrayList<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate));
    }

    private void orderListDesc(ArrayList<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate).reversed());
    }
}