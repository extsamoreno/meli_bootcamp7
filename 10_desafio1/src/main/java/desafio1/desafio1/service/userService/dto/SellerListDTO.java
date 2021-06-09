package desafio1.desafio1.service.userService.dto;

import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SellerListDTO {
    private int userId;
    private String userName;
    private List<UserSaveDTO> followMeList;


    public SellerListDTO() {
        this.followMeList = new ArrayList<>();
    }
}

