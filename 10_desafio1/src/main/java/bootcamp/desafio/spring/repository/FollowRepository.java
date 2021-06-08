package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Follow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FollowRepository implements IFollowRepository{


    ArrayList<Follow> followDB;

    public FollowRepository() {
        followDB = new ArrayList<>();
    }

    @Override
    public List<Follow> findAll() {
        return followDB;
    }

    @Override
    public ArrayList<Follow> findByIdFollower(Long followerId) {
        ArrayList<Follow> userFilter = (ArrayList<Follow>) followDB
                .stream()
                .filter(follow -> follow.getIdUserFollower().equals(followerId)).collect(Collectors.toList());
        return userFilter;
    }

    @Override
    public ArrayList<Follow> findByIdFollow(Long followId) {
        ArrayList<Follow> userFilter = (ArrayList<Follow>) followDB
                .stream()
                .filter(follow -> follow.getIdUserFollow().equals(followId))
                .collect(Collectors.toList());
        return userFilter;
    }

    @Override
    public Follow save(Follow follow) {
        followDB.add(follow);
        return follow;
    }
}
