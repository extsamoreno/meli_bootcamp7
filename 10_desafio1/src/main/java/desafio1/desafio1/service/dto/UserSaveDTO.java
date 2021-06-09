package desafio1.desafio1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveDTO { //esta clase son los que se guardan en los seguidores de cada uno, para no guardar el objeto entero de usuario
    private int userId;
    private String userName;
}

