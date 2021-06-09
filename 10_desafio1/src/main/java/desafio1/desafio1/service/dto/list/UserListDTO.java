package desafio1.desafio1.service.dto.list;

import desafio1.desafio1.service.dto.UserSaveDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserListDTO {
    private int userId;
    private String userName;
    private List<UserSaveDTO> followList;


    public UserListDTO() {
        this.followList = new ArrayList<>();
    }
}

