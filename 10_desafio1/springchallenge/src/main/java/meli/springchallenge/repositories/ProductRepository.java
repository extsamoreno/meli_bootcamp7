package meli.springchallenge.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void createProduct(Product product) {
        this.products.add(product);

    }

    @Override
    public void createPost(Post post) {
        this.posts.add(post);
    }

    @Override
    public List<Post> getPostByUserId(int userId) {

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
