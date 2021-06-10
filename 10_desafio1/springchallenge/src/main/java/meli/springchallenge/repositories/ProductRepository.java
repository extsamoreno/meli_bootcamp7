package meli.springchallenge.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products;
    private List<Post> posts;

    public ProductRepository() {
        this.products = loadProductsDB();
        this.posts = loadPostDB();
    }

    @Override
    public void createProduct(Product product) throws ProductIdNotValidException {
        validateProductId( product.getProductId());
        this.products.add(product);

    }

    @Override
    public void createPost(Post post) throws PostIdNotValidException {
        validatePostId(post.getPostId());
        this.posts.add(post);
    }

    @Override
    public Post getPostById(int postId) {
        try{
            return posts.stream().filter(p-> postId == p.getPostId()).findFirst().get();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {

        List<Post> posts = new ArrayList<>();

        for(Post p:this.posts) {
            if (p.getUserId() == userId){
                posts.add(p);
            }
        }
        return posts;
    }

    @Override
    public Product getProductById(int productId) {

        for(Product p:products){
            if (p.getProductId() == productId){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(int productId) {
        this.products.remove(products.stream().filter(p->p.getProductId()==productId).findFirst().get());
    }

    @Override
    public void deletePost(int postId) {
        this.posts.remove(posts.stream().filter(p->p.getProductId()==postId).findFirst().get());
    }

    private boolean validatePostId(int postId) throws PostIdNotValidException {

        for(Post p:this.posts) {
            if (p.getPostId() == postId){
                throw new PostIdNotValidException(postId);
            }
        }
        return true;

    }

    private boolean validateProductId(int productId) throws ProductIdNotValidException {

        for(Product p:this.products) {
            if (p.getProductId() == productId){
                throw new ProductIdNotValidException(productId);
            }
        }
        return true;

    }


    private List<Product> loadProductsDB() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:products.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};

        List<Product> db = null;

        try {
            db = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return db;
    }

    private List<Post> loadPostDB() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};

        List<Post> db = null;

        try {
            db = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return db;
    }
}
