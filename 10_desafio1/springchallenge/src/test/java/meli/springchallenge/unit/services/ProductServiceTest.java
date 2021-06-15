package meli.springchallenge.unit.services;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.ProductDTO;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.exceptions.SocialMeliException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;
import meli.springchallenge.repositories.ProductRepository;
import meli.springchallenge.repositories.UserRepository;
import meli.springchallenge.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void createProductOKTest() throws UserNotValidException, PostIdNotValidException, ProductIdNotValidException {
        // Arrange
        int userId = 2;
        int productId = 14;
        Product expectedProduct = new Product(productId,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red & Black",
                "Special Edition");

        Post expectedPost = new Post(userId,
                19,
                new Date(2021-06-13),
                productId,
                100,
                1500.50,
                false,
                0.0);

        ProductDTO product = new ProductDTO(14,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red & Black",
                "Special Edition");
        PostDTO post = new PostDTO(userId,
                19,
                new Date(2021-06-13),
                product,
                100,
                1500.50,
                false,
                0.0);
        when(userRepository.validateUser(userId)).thenReturn(true);
        doNothing().when(productRepository).createPost(expectedPost);
        doNothing().when(productRepository).createProduct(expectedProduct);

        // Act
        productService.createPost(post);

        // Assert
        verify(userRepository, times(1)).validateUser(userId);
        verify(productRepository, times(1)).createProduct(expectedProduct);
        verify(productRepository, times(1)).createPost(expectedPost);

    }

    @Test
    public void createProductUserNotValidTest() throws UserNotValidException, PostIdNotValidException, ProductIdNotValidException {
        // Arrange
        int userId = 2;

        ProductDTO product = new ProductDTO(14,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red & Black",
                "Special Edition");
        PostDTO post = new PostDTO(userId,
                19,
                new Date(2021-06-13),
                product,
                100,
                1500.50,
                false,
                0.0);

        when(userRepository.validateUser(userId)).thenThrow(new UserNotValidException(userId));


        // Act
        SocialMeliException exception = assertThrows(UserNotValidException.class, () -> productService.createPost(post));
        System.out.println("exception.toString() = " + exception.toString());

        // Assert
        assertEquals("UserID #" + userId + " is not valid ", exception.getError().getMessage());

    }
}


