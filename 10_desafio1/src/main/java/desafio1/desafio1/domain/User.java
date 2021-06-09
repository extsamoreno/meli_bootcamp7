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
    private List<UserSaveDTO> followList; //quienes sigo yo
    private List<UserSaveDTO> followMeList; //quienes me siguen
    private List<Publications> publicationsList;

    public User() {
        this.followList = new ArrayList<>();
        this.followMeList = new ArrayList<>();
        this.publicationsList = new ArrayList<>();
    }

    //el usuario comun y el vendedor don el mismo tipo de objeto, cuando se tratae de un vendedor,
    //tendra las listas de publicaciones, sino estará vacia, ademas el nombre será o usuario o vendedor

}
