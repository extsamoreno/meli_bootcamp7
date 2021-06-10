package com.desafio.socialMeli.repository;

import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.PostDTO;
import com.desafio.socialMeli.service.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/*
* OBSERVACION:
* Utilice solo un repositorio el cual contiene "dos tablas" = dos hashmaps que representan dos tablas en donde se guarda
* la informacion. Intete que los metodos sean genericos para que los mismos puedan realizar ABMs a ambas tablas.
* */
@Repository
public class SocialMeliRepository implements ISocialMeliRepository {
    public static int POSTDTO_TABLE = 1;
    public static int USERDTO_TABLE = 2;
    public static String USERDTONAME = "UserDTO";
    public static String POSTDTONAME = "PostDTO";


    private HashMap<Integer, UserDTO> userDTOMap = new HashMap<Integer, UserDTO>();
    private HashMap<Integer, PostDTO> postDTOMap = new HashMap<Integer, PostDTO>();


    @Override
    public boolean tableInRepositoryStatus(Integer table){
        boolean res = true;
        if(getTable(table) == null) res = false;
        return res;
    }

    @Override
    public <T> T getDTOById(Integer id, Integer table) {
        if (tableInRepositoryStatus(table) && getTable(table).containsKey(id)) {
            return (T) getTable(table).get(id);
        }
        return null;
    }

    @Override
    public List<PostDTO>getPostDTOListByUserId(Integer userid) {
        int tableSize = this.postDTOMap.size();
        List<PostDTO> PostDTOList = new ArrayList<PostDTO>();
        for (int i = 1; i <= tableSize; i++) {
            PostDTO postDTO = getDTOById(i, POSTDTO_TABLE);
            PostDTOList.add(postDTO);
        }
        return PostDTOList;
    }


    private <T> HashMap<Integer, T> getTable(int table){
        if(table == POSTDTO_TABLE) return (HashMap<Integer, T>) this.postDTOMap;
        if(table == USERDTO_TABLE) return (HashMap<Integer, T>) this.userDTOMap;
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
    public <T> HashMap<Integer, T> getOrCreateDTOTable(Integer table) {

        if (this.getTable(table) == null) {
            if(table == USERDTO_TABLE) this.userDTOMap = new HashMap<Integer, UserDTO>() {};
            if(table == POSTDTO_TABLE) this.postDTOMap = new HashMap<Integer, PostDTO>() {};
        }
        return this.getTable(table);
    }

    private <T> Integer getTableNameFromRepositoryByDTO(T t) {
        Integer table = 0;
        if (t.getClass().getName().contains(USERDTONAME)) table = USERDTO_TABLE;
        if (t.getClass().getName().contains(POSTDTONAME)) table = POSTDTO_TABLE;
        return table;
    }

    // busca y sobreEscribe o lo ingresa al final
    @Override
    public <T> boolean updateDTORepository(T t) {
        boolean res = true;
        int table = getTableNameFromRepositoryByDTO(t);

        if(this.getTable(table) != null && table != 0) {
            HashMap<Integer, T> map = this.getTable(table);
            if (map.isEmpty()) this.getTable(table).put(1, t);
            else {
                Integer index = indexOfDTOinRepository(t);
                if (index == -1) this.getTable(table).put((map.size() + 1), t);
                else this.getTable(table).put(index, t);
            }
        }else res = false;
        return res;
    }

    // retorna -1 si no lo puede encontrar
    @Override
    public <T> Integer indexOfDTOinRepository(T t){
        Integer index = -1;
        int table = getTableNameFromRepositoryByDTO(t);
        if(!this.getTable(table).isEmpty() && table != 0){
            for (Integer i = 0; i <= this.getTable(table).size(); i++) {
                if (this.getTable(table).get(i) == t) index = i;
            }
        }
        return index;
    }

}