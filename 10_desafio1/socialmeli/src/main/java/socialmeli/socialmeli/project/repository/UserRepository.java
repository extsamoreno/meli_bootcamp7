package socialmeli.socialmeli.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.utils.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class UserRepository implements IUserRepository{
    public static List<User> listUsers = Database.listUsers; //List of users
    public static HashMap<Integer, ArrayList<User>> mapUsersFollowers = Database.mapUsersFollowers; //Map to save usersId and their followers list
    public static HashMap<Integer, ArrayList<User>> mapUsersFollowed= Database.mapUsersFollowed; //Map to save usersId and their users followed list


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
