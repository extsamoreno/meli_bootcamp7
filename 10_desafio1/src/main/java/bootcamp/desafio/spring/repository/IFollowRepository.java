package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Follow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IFollowRepository {

    List<Follow> findAll();

    ArrayList<Follow> findByIdFollower(Long followerId);

    ArrayList<Follow> findByIdFollow(Long followId);

    Follow save(Follow follow);
}
