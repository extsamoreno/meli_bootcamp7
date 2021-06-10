package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.*;
import com.example.DesafioSpring.models.Post;
import com.example.DesafioSpring.models.Product;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.repositories.IUserRepository;
import com.example.DesafioSpring.services.mapper.PostMapper;
import com.example.DesafioSpring.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImple extends OrderByService<PostDTO> implements IPostService {

    @Autowired
    IUserRepository iUserRepository;

//metodo que pregunta si el post ya esta en uso
    private Boolean postTaken(int postId) {
        try {
            iUserRepository.getPostByID(postId);
            return true;
        } catch (PostNotFoundException e) {
            return false;
        }
    }
    //metodo que pregunta si el producto ya esta en uso o tomado por su ID
    private Boolean productTaken(int productId) {
        try {
            iUserRepository.getProductByID(productId);
            return true;
        } catch (ProductNotFoundException e) {
            return false;
        }
    }

    //guarda los productos si no estan tomados, caso contrario excepcion
    public void productSave(Product product) throws ProductTakenException {
        List<Product> products = iUserRepository.getProducts();

        if (!this.productTaken(product.getId())) {
            products.add(product);
        } else {
            throw new ProductTakenException(product.getId());
        }

    }
//Guarda un posteo
    public void postSave(Post post) throws PostTakenException, UserNotFoundException {

        User user = iUserRepository.getUserByID(post.getUserId());

        List<Post> posts = iUserRepository.getPosts();
        if (!this.postTaken(post.getId())) {
            user.getPosts().add(post.getId());
            posts.add(post);
        } else {
            throw new PostTakenException(post.getId());
        }

    }
//nuevo post SIN PROMOCION
    @Override
    public void newPost(NoPromoDTO postDTO) throws ProductTakenException, PostTakenException, UserNotFoundException {

        Post post = PostMapper.toPost(postDTO);
        informationSave(post, postDTO.getDetail());

    }
//guarda informacion de un producto y un post
    private void informationSave(Post post, ProductDTO detail) throws ProductTakenException, PostTakenException, UserNotFoundException {

        Product product = ProductMapper.toProduct(detail);

        if (this.productTaken(product.getId())) {
            throw new ProductTakenException(product.getId());
        }
        if (this.postTaken(post.getId())) {
            throw new PostTakenException(post.getId());
        }
        this.postSave(post);
        this.productSave(product);
    }

    //Nuevo posteo CON PROMOCION
    @Override
    public void newPost(PromoPostDTO postDTO) throws ProductTakenException, PostTakenException, UserNotFoundException {

        Post post = PostMapper.toPost(postDTO);
        informationSave(post, postDTO.getDetail());

    }

    //metodo que retorna seguidores de post y ordena por fecha
    @Override
    public PostsConstructorDTO getFollowedByPost(int userId, String order) throws PostNotFoundException, UserNotFoundException, ProductNotFoundException {

        User user = iUserRepository.getUserByID(userId);
        List<PostDTO> output = new ArrayList<>();
        for (int i = 0; i < user.getFollowing().size(); i++) {
            User followed = iUserRepository.getUserByID(user.getFollowing().get(i));
            List<Post> posts = iUserRepository.getPostsByIds(followed.getPosts());
            for (int j = 0; j < posts.size(); j++) {
                Product product = iUserRepository.getProductByID(posts.get(j).getProductId());
                output.add(PostMapper.toDTO(posts.get(j), product));
            }
        }

        this.postByDate(output, LocalDate.now().minusWeeks(2), LocalDate.now());
        this.bubbleSort(output, this.getComparator(order));

        return new PostsConstructorDTO(user.getId(), user.getName(), output);
    }

    //metodo de comparacion por iD o fecha y por tipo ascendente y descendente
    private Comparator<PostDTO> getComparator(String order) {
        Comparator<PostDTO> comparator;
        String orderBy = this.orderBy(order);
        String orderType = this.orderType(order);
        switch (orderBy) {
            case "date":
                comparator = Comparator.comparing(PostDTO::getDate);
            case "id":
                comparator = Comparator.comparing(PostDTO::getPostId);
            default:
                comparator = Comparator.comparing(PostDTO::getDate);
                ;
        }
        switch (orderType) {
            case "desc":
                comparator = comparator.reversed();
        }
        return comparator;

    }

    //metodo que filtra post/publicaciones
    private void postByDate(List<PostDTO> posts, LocalDate from, LocalDate until) {

        for (int i = 0; i < posts.size(); i++) {
            LocalDate postDate = posts.get(i).getDate(); //fecha de publicacion hoy
            Boolean greaterThan = (postDate.isAfter(from) || postDate.isEqual(from)); //fecha publicacion es mayor o igual a fecha actual
            Boolean smallerThan = (postDate.isBefore(until) || postDate.isEqual(until)); //fecha publicacion anterior o igual a fecha actual

            if (!(greaterThan && smallerThan)) {
                posts.remove(i);
            }
        }

    }

    //retorna publicaciones con promocion
    @Override
    public PostCounterDTO postWithPromo(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {

        User user = iUserRepository.getUserByID(userId);

        return new PostCounterDTO(user.getId(), user.getName(), this.sellerPromoList(userId).getPosts().size());

    }
//lista de promociones de un vendedor
    public PostsConstructorDTO sellerPromoList(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {

        User user = iUserRepository.getUserByID(userId);
        List<PostDTO> output = new ArrayList<>();
        List<Post> posts = iUserRepository.getPostsByIds(user.getPosts());
        for (int j = 0; j < posts.size(); j++) {
            if (posts.get(j).getHasPromo()) {
                Product product = iUserRepository.getProductByID(posts.get(j).getProductId());
                output.add(PostMapper.toDTO(posts.get(j), product));
            }
        }

        return new PostsConstructorDTO(user.getId(), user.getName(), output);

    }
}
