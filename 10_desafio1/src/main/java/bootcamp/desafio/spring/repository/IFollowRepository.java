package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Follow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IFollowRepository {

    List<Follow> findAll();

    /**
     * Obtengo lista de todas las personas a las que sige una persona
     * @param followerId userId de cliente Vendedor
     * @return listaDeRelacion
     */
    ArrayList<Follow> findByIdFollower(Long followerId);

    /**
     * Obtengo lista de todas las personas que esta siguiendo una persona
     * @param followId userId de cliente
     * @return listaDeRelacion
     */
    ArrayList<Follow> findByIdFollowing(Long followId);

    Follow save(Follow follow);

    void remove(Follow follow);
}
