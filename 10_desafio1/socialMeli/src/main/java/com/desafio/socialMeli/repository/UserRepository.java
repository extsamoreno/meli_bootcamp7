package com.desafio.socialMeli.repository;



import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private HashMap<Integer, UserDTO> map;

    @Override
    public UserDTO getUserDTOById(Integer id) {
        if (this.map.containsKey(id)) {
            return this.map.get(id);
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        List<User> userList = loadDatabase();
        User result = new User();
        if (userList != null) {
            Optional<User> item = userList.stream().filter(user -> user.getId() == id).findFirst();
            if (item.isPresent()) {
                result = item.get();
            }
        }
        return result;
    }

    @Override
    public List<User> getUserList() {
        return loadDatabase();
    }

    private List<User> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            System.out.println("ENCONTRE EL ARCHIVO: " + file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> ingrediente = null;
        try {
            ingrediente = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }

    @Override
    public Map<Integer, UserDTO> getOrCreateUserDTORepository() {
        if (this.map == null)
            this.map = new HashMap<Integer, UserDTO>() {};
        return this.map;
    }

    // busca y sobreEscribe o lo ingresa al final
    @Override
    public boolean updateUserDTORepositoy(UserDTO userDTO) {

        if(map.isEmpty())   map.put(1, userDTO);
        else{
            Integer index = containsUserDTO(userDTO);
            if(index == 0){
                this.map.put((this.map.size() + 1), userDTO);
            }else{
                this.map.put(index, userDTO);
            }
        }
        return true;
    }

    private Integer containsUserDTO(UserDTO userDTO){
        Integer i = 0;

        if(map.isEmpty()) return 0;
        else {
            for (i = 0; i <= this.map.size(); i++) {
                if (this.map.get(i) == userDTO) return i;
            }
        }
        return 0;
    }

}