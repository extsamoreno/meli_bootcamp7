package meli.springchallenge.services.mapper;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.ProductDTO;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;

public class PostMapper {

    public static Product productToModel(ProductDTO prodDTO){
        return new Product(
                prodDTO.getProductId(),
                prodDTO.getProductName(),
                prodDTO.getType(),
                prodDTO.getBrand(),
                prodDTO.getColor(),
                prodDTO.getNotes());
    }
    public static Post postToModel(PostDTO postDTO){
        return new Post(
                postDTO.getUserId(),
                postDTO.getPostId(),
                postDTO.getDate(),
                postDTO.getDetail().getProductId(),
                postDTO.getCategory(),
                postDTO.getPrice(),
                postDTO.isHasPromo(),
                postDTO.getDiscount());
    }

    public static PostDTO postToDTO(Post post, Product product){

        ProductDTO prodDTO = productToDTO(product);

        return  new PostDTO(
                post.getUserId(),
                post.getPostId(),
                post.getDate(),
                prodDTO,
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public static ProductDTO productToDTO(Product product){
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }
}
