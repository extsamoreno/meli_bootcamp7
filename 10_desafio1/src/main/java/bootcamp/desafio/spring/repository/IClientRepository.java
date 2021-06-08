package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);
}
