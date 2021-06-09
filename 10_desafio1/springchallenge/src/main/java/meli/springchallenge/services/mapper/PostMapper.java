package meli.springchallenge.services.mapper;

import meli.springchallenge.dtos.FollowedPostDTO;
import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.ProductDTO;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;

import java.util.List;

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

    public static PostDTO postToDTO(Post post, Product product){

        ProductDTO prodDTO = productToDTO(product);

        return  new PostDTO(
                post.getUserId(),
                post.getPostId(),
                DateMapper.toString(post.getDate()),
                prodDTO,
                post.getCategory(),
                post.getPrice()
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
