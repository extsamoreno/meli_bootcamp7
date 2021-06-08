package desafio1.desafio1.service;

import desafio1.desafio1.service.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {
    @Override
    public UserDTO getUser(int userIdToFollow) {
        return null;//cuadno cree la bdd la consulto y devuelvo el usuario
    }
}
