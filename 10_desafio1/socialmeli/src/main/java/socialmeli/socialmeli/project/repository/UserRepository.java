package socialmeli.socialmeli.project.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class UserRepository implements IUserRepository{
        public static List<User> listUsers = new ArrayList<>();
        private static HashMap<Integer, ArrayList<User>> mapUsersFollowers= new HashMap<>(); //Map to save users and their followers list
        private static HashMap<Integer, ArrayList<User>> mapUsersFollowed= new HashMap<>(); //Map to save users and their users followed list

       @Override
        public void loadDataBase() {
            File file = null;

            try {
                file = ResourceUtils.getFile("classpath:users.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<User>> typeRef = new TypeReference<>() {};
            List<User> listUsers = null;

            try{
                listUsers = objectMapper.readValue(file , typeRef);
            }catch (IOException e){
                e.printStackTrace();
            }

            for(User u: listUsers){
                this.listUsers.add(u);
            }
        }

    @Override
        public void instanceMapUsersFollowers(){
            for (User u: listUsers) {
                mapUsersFollowers.put(u.getUserId(),new ArrayList<>());
                mapUsersFollowed.put(u.getUserId(),new ArrayList<>());
            }
        }

    @Override
        public ArrayList<User> getUserFollowersList (Integer userId) throws IdNotFoundException {
            if (mapUsersFollowers.get(userId)==null){
                throw new IdNotFoundException(userId.toString());
            }
            return mapUsersFollowers.get(userId);
        }

    @Override
    public ArrayList<User> getUserFollowedList(Integer userId) throws IdNotFoundException {
        if (mapUsersFollowed.get(userId)==null){
            throw new IdNotFoundException(userId.toString());
        }
        return mapUsersFollowed.get(userId);
    }

    @Override
    public User findUserById (Integer userId) throws IdNotFoundException {
            return listUsers.stream()
                    .filter(user -> user.getUserId() == userId)
                    .findFirst().orElseThrow(()-> new IdNotFoundException(userId.toString()));
        }

}
