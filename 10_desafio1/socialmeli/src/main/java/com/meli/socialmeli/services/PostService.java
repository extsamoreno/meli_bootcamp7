package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserPostListDTO;
import com.meli.socialmeli.exceptions.UserIsNotMerchant;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPostRepository;

    /**
     * Recibe como paramaetro un JSON en el Body, este es mapeado como Post en la base de datos. Este post es asignado
     * al usuario con el Id que viene en el JSON.
     * @param post JSON con los datos requeridos de un Post
     */
    @Override
    public void newPost(Post post) throws UserIsNotMerchant {
        iPostRepository.newPostAdd(post);
    }

    /**
     * Recibe como paramatros el Id del usuario a consultar, y un string que indica
     * el tipo de ordenamiento ( date_asc o date_desc). Retorna el Id del usuario consultado, el nombre y la lista
     * de los post de la ultimas dos semenas.
     * @param userId Id del usuario a consultar
     * @param order String opcional para elegir la forma de ordenamiento, ascendente o descendente.
     * @return UserPostListDTO contiene el Id del usuario consultado y un listado de los Post de las dos últimas semanas
     */
    @Override
    public UserPostListDTO getListPosts(int userId, String order) {
        return iPostRepository.getPostListById(userId, order);
    }

}
