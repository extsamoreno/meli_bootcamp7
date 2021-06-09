package desafio1.desafio1.service.dto;

import desafio1.desafio1.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private String userName;
    private List<UserSaveDTO> followList; //quienes sigo yo
    private List<UserSaveDTO> followMeList; //quienes me siguen


    public UserDTO() {
        this.followList = new ArrayList<>();
        this.followMeList = new ArrayList<>();
    }
}

