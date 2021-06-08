package meli.social.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.social.exception.UserIdNotFoundException;
import meli.social.model.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<UserModel> seedUsers() {
        List<UserModel> allUsers = null;
        allUsers = loadDataBase();
        return allUsers;
    }

    @Override
    public UserModel findUserById(int userId) throws UserIdNotFoundException {
        List<UserModel> allUsers = null;
        allUsers = loadDataBase();
        UserModel foundUser = null;
        if (allUsers != null) {
            try {
                foundUser = allUsers.get(userId);
            } catch (Exception e) {
                throw new UserIdNotFoundException(userId);
            }
        }
        return foundUser;
    }

    private List<UserModel> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserModel>> typeRef = new TypeReference<>() {};
        List<UserModel> allUsers = null;
        try {
            allUsers = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allUsers;
    }
}
