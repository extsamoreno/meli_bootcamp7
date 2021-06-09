package desafio1.desafio1.service.dto.list;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.service.dto.UserSaveDTO;
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

