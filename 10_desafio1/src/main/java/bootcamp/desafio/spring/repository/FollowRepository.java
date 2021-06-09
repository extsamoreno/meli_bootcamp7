package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Follow;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FollowRepository implements IFollowRepository{


    ArrayList<Follow> followDB;

    public FollowRepository() {
        followDB = LoadDataBase();
    }

    @Override
    public List<Follow> findAll() {
        return followDB;
    }

    @Override
    public ArrayList<Follow> findByIdFollower(Long followerId) {
        ArrayList<Follow> followArrayList = (ArrayList<Follow>) followDB
                .stream()
                .filter(follow -> follow.getIdUserFollower().equals(followerId)).collect(Collectors.toList());
        return followArrayList;
    }

    @Override
    public ArrayList<Follow> findByIdFollowing(Long followId) {
        ArrayList<Follow> followArrayList = (ArrayList<Follow>) followDB
                .stream()
                .filter(follow -> follow.getIdUserFollowing().equals(followId))
                .collect(Collectors.toList());
        return followArrayList;
    }

    @Override
    public Follow save(Follow follow) {
        Optional<Follow> followFilter =followDB.stream()
                .filter(followStream -> followStream.equals(follow))
                .findFirst();
        if(!followFilter.isPresent()){
            followDB.add(follow);
        }
        return follow;
    }

    @Override
    public void remove(Follow follow) {
        Optional<Follow> followFilter =followDB.stream()
                .filter(followStream -> followStream.equals(follow))
                .findFirst();
        if(followFilter.isPresent()){
            followDB.remove(follow);
        }
    }


    private ArrayList<Follow> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/follows.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<Follow>> typeRef = new TypeReference<>() {};
        ArrayList<Follow> follows = null;
        try {
            follows = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return follows;
    }
}
