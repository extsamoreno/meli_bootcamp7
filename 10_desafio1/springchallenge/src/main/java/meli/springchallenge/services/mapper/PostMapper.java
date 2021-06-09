package meli.springchallenge.services.mapper;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.ProductDTO;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;

public class PostMapper {

    public static Product productToModel(ProductDTO prodDTO){
        return new Product(
                prodDTO.getProduct_id(),
                prodDTO.getProductName(),
                prodDTO.getType(),
                prodDTO.getBrand(),
                prodDTO.getColor(),
                prodDTO.getNotes());
    }
    public static Post postToModel(PostDTO postDTO){
        return new Post(
                postDTO.getUserId(),
                postDTO.getId_post(),
                DateMapper.toDate(postDTO.getDate()),
//                postDTO.getDate(),
                postDTO.getDetail().getProduct_id(),
                postDTO.getCategory(),
                postDTO.getPrice());
    }
}
