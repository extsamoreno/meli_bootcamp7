package bootcamp.desafio.spring.service;

import bootcamp.desafio.spring.exception.DateException;
import bootcamp.desafio.spring.exception.PostException;
import bootcamp.desafio.spring.exception.PostUserNotFoundException;
import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.service.dto.CantPromoDTO;
import bootcamp.desafio.spring.service.dto.PostPromoListDTO;
import bootcamp.desafio.spring.service.dto.PostRequestDTO;
import bootcamp.desafio.spring.service.dto.ProductFollowedDTO;

import java.util.ArrayList;

public interface IProductService {

    /**
     * metodo para guardar o actualizar una publicacion
     * @param post
     * @throws PostUserNotFoundException
     * @throws DateException
     */
    void addNewPost(PostRequestDTO post) throws PostUserNotFoundException, DateException;

    /**
     * metodo para traer todas las publicaciones de los ultimos 14 dias
     * de la gente a la que sigue el usuario con el UserID y ordenarlo por fecha
     * @param userId
     * @param order
     * @return
     */
    ProductFollowedDTO getPostTheFollows(Long userId, String order);


    /**
     * metodo para añadir una publicacion con descuento
     * @param post
     * @throws PostException
     * @throws DateException
     */
    void addNewPostPromo(PostRequestDTO post) throws PostException, DateException;

    /**
     * obtener la caaantidad de publicaciones con promo que tiene un vendedor
     * @param userId
     * @return
     * @throws PostUserNotFoundException
     */
    CantPromoDTO getPromosBySeller(Long userId) throws PostUserNotFoundException;

    /**
     * metodo para traer las promociones del usuario(vendedor) y ordenarlos por fecha o porcentaje de descuento
     * @param userId
     * @param order
     * @return PostPromoListDTO
     * @throws PostUserNotFoundException
     */
    PostPromoListDTO getPromosBySellerList(Long userId, String order) throws PostUserNotFoundException;

    /**
     * metodo para ver toda la informacion de las publicaciones
     * utilizado para actualizar posts.json
     * @return ArrayList<Post>
     */
    ArrayList<Post> getAll();
}
