package desafio1.desafio1.domain;

import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor

public class User {
    private int userId;
    private String userName;
    private int isSeller;
    private List<UserSaveDTO> followList; //who i follow
    private List<UserSaveDTO> followMeList; //who follows me
    private List<Publications> publicationsList;

    public User() {
        this.followList = new ArrayList<>();
        this.followMeList = new ArrayList<>();
        this.publicationsList = new ArrayList<>();
    }

    /**
     * the common user and the seller are the same type of object,
     * when it is a seller it will have the isSeller attribute at 1, otherwise it will be at 0.
     */

}
