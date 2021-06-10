package desafio1.desafio1.service.userService.dto;

import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private String userName;
    private int isSeller;
    private List<UserSaveDTO> followList;
    private List<UserSaveDTO> followMeList;


    public UserDTO() {
        this.followList = new ArrayList<>();
        this.followMeList = new ArrayList<>();
    }
}

